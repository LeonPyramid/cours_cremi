#define _GNU_SOURCE
#include "Shell.h"
#include "Evaluation.h"

#include <stdio.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <fcntl.h>


#define MXSIZE 256

int mpipe[2];
enum{R,W};

void verifier(int cond, char *s)
{
  if (!cond)
  {
    perror(s);
    exit(EXIT_FAILURE);
  }
}


int evaluer_expr(Expression *e)
{
  pid_t bgSon;                      //Used in BG to print the pid of the child process
  pid_t pid;                        //Used in SIMPLE to wait the created process
  int res;                          //used to get the return value of  evaluer_expr to know if it ended correctly or not
  int zstat;                        //recover stat from zombie BG process
  
  //Zombie handler
  res = waitpid(-1,&zstat,WNOHANG);
  if(res != -1){
    printf("%d fini : %d\n",res,zstat);
  }


  switch (e->type)
  {
  case VIDE:
    return 0;
    break;

  case SIMPLE:
  if(strcmp(e->arguments[0],"exit")==0){
    exit(EXIT_SUCCESS);
  }
    pid = fork();
    if (pid != 0)
    {
      int stat;
      waitpid(pid,&stat,0);
      return(stat);
    }
    else
    {
      execvp(e->arguments[0], e->arguments);
      char errmsg[MXSIZE] = "Execution Error: ";
      strcat(errmsg,e->arguments[0]);
      perror(errmsg);
      exit(EXIT_FAILURE);
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
      printf("%d\n",bgSon);
      return 0;
    }
    else{
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
    break;

  default:
    fprintf(stderr, "not yet implemented %d\n", e->type);
    return 1;
  }
  
  fprintf(stderr, "Error : your'e reaching out of your code!\n"); //Usually tthe break; is never accessed in any of the case, so going here is forbidden
  return 1;
}


