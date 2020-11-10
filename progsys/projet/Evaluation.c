#define _GNU_SOURCE
#include "Shell.h"
#include "Evaluation.h"

#include <stdio.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <errno.h>


#define MXSIZE 256

int mpipe[2];
enum{R,W};
enum{STDIN = STDIN_FILENO,
     STDOUT = STDOUT_FILENO,
     STDERR = STDERR_FILENO,
     STDOUT_ERR};//Declared for Redirection mode

struct sigaction schld;
sigset_t set;//used to avoid bg process tro recieve sigint


void verifier(int cond, char *s)
{
  if (!cond)
  {
    perror(s);
    exit (EXIT_FAILURE);
  }
}


void sigchld_halder(int id){//Used to handle sigchld
  int stat;
  pid_t w = waitpid(0, &stat, WNOHANG);
  if(w > 0){
    printf("%d fini: %d\n",w,stat);
  }
}

//Redirection in or out file. Always same code (except for OUT + ERR)
//redir = STDIN/STDOUT/STDERR/STDOUT_ERR
//param = the parameters given to open
int file_redir(Expression *e,int redir,int param){

  if(e->arguments[0]!=NULL){
      int save;
      int save2;
      int fd = open(e->arguments[0],param,0666);
      if(fd == -1){
        perror("Error file openning");
        return errno;
      }
      if(redir != STDOUT_ERR){
        save = dup(redir);
        verifier(save!=-1,"Error dup std");
        verifier((dup2(fd,redir)!=-1),"Error dup2 file into std");
        close(fd);
      }
      else{
        save = dup(STDOUT_FILENO);
        verifier(save!=-1,"Error dup stdout");
        save2 = dup(STDERR_FILENO);
        verifier(save2!=-1,"Error dup stderr");
        verifier((dup2(fd,STDOUT_FILENO)!=-1),"Error dup2 file into stdout");
        verifier((dup2(fd,STDERR_FILENO)!=-1),"Error dup2 file into stderr");
        close(fd);
      }
      int stat = evaluer_expr(e->gauche);
      if(redir!=STDOUT_ERR){
        verifier((dup2(save,redir))!=-1,"Error dup2 saved std into std");
        close(save);
      }
      else{
        verifier((dup2(save,STDOUT_FILENO))!=-1,"Error dup2 saved stdout into stdout");
        close(save);
        verifier((dup2(save2,STDERR_FILENO))!=-1,"Error dup2 saved stderr into stderr");
        close(save2);
      }
      return stat;
    }
    else{
      fprintf(stderr,"Error no file specified!\n");
      return 1;
    }
}

int evaluer_expr(Expression *e)
{
  
  pid_t bgSon;                      //Used in BG to print the pid of the child process
  pid_t pid;                        //Used in SIMPLE to wait the created process
  int res;                          //used to get the return value of  evaluer_expr to know if it ended correctly or not


  //handle sigchld
  schld.sa_flags = 0;
  sigemptyset(&schld.sa_mask);
  schld.sa_handler = sigchld_halder;
  sigaction(SIGCHLD,&schld,NULL);
  
  //Ingore sigint
  signal(SIGINT, SIG_IGN);

  /* Old Zombie Handler
  int zstat;                        //recover stat from zombie BG process
  res = waitpid(-1,&zstat,WNOHANG);
  if(res != -1){
    printf("%d fini : %d\n",res,zstat);
  }*/

  switch (e->type)
  {
  case VIDE:
    return 0;
    break;

  case SIMPLE:
    if(strcmp(e->arguments[0],"exit")==0){
      exit(EXIT_SUCCESS);
    }
    else if(strcmp(e->arguments[0],"echo")==0)
    {
      if(e-> arguments[1]!=NULL){
        printf(e->arguments[1]);
        int i = 2;
        while(e->arguments[i]!=NULL){
          printf(" ");
          printf(e->arguments[i]);
          i++;
        }
      }
      printf("\n");
      return 0;
    }
    else if(strcmp(e->arguments[0],"source")==0){
      //TODO:Gérer les source
    }
    else{
      pid = fork();
      if (pid != 0)
      {
        int stat;
        waitpid(pid,&stat,0);
        return(stat);
      }
      else
      {
        signal(SIGINT,SIG_DFL);
        execvp(e->arguments[0], e->arguments);
        char errmsg[MXSIZE] = "Execution Error: ";
        strcat(errmsg,e->arguments[0]);
        perror(errmsg);
        exit(EXIT_FAILURE);
      }
    }
    break;

  case SEQUENCE:
    evaluer_expr(e->gauche);
    return evaluer_expr(e->droite);
    break;

  case SEQUENCE_ET:
    res = evaluer_expr(e->gauche); 
    if(res == 0)
      return evaluer_expr(e->droite);
    return res;
    break;
  
  case SEQUENCE_OU:
    res = evaluer_expr(e->gauche);
    if(res != 0)
      return evaluer_expr(e->droite);
    return 0;
    break;

  case BG:
    bgSon = fork();
    if(bgSon != 0){
      printf("bg: %d\n",bgSon);
      return 0;
    }
    else{
      //Avoid bg process to recieve sigint
      sigaddset(&set,SIGINT);
      sigprocmask(SIG_SETMASK,&set,NULL);

      close(STDIN_FILENO);//avoid bg process to read terminal
      res = evaluer_expr(e->gauche);
      exit(EXIT_SUCCESS);
    }
    break;

  case PIPE:

    verifier(pipe(mpipe)==0,"Error pipe creation");
    if(fork()!=0){
      close(mpipe[W]);
      int inSave = dup(STDIN_FILENO);
      dup2(mpipe[R],STDIN_FILENO);
      close(mpipe[R]);
      res = evaluer_expr(e->droite);
      dup2(inSave,STDIN_FILENO);
      close(inSave);
      wait(0);
      return res;
    }
    else{
      close(mpipe[R]);
      int outSave = dup(STDOUT_FILENO);
      dup2(mpipe[W],STDOUT_FILENO);
      close(mpipe[W]);
      res = evaluer_expr(e->gauche);
      dup2(outSave,STDOUT_FILENO);
      if(res != 0){
        exit(EXIT_FAILURE);
      }
      exit(EXIT_SUCCESS);
    }
    break;

  case REDIRECTION_I:
    return file_redir(e,STDIN,O_RDONLY);
    break;

  case REDIRECTION_O:
    return file_redir(e,STDOUT,O_WRONLY|O_CREAT|O_TRUNC);
    break;

  case REDIRECTION_A:
    return file_redir(e,STDOUT,O_WRONLY|O_CREAT|O_APPEND);
    break;
  case REDIRECTION_E:
    return file_redir(e,STDERR,O_WRONLY|O_CREAT|O_TRUNC);
    break;

  case REDIRECTION_EO:
    return file_redir(e,STDOUT_ERR,O_WRONLY|O_CREAT|O_TRUNC);
    break;

  default:
    fprintf(stderr, "not yet implemented %d\n", e->type);
    return 1;
  }
  
  fprintf(stderr, "Error : your'e reaching out of your code!\n"); //Usually the break; is never accessed in any of the case, so going here is forbidden
  return 1;
}


