#define _GNU_SOURCE
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <string.h>

#define MAXLN 1
int pipe_1[2];
int pipe_2[2];

enum { R, W };



void verifier(int i, char *s)
{
  if (!i) {
    perror (s);
    exit (EXIT_FAILURE);
  }
}


int main(int argc, char const *argv[])
{
    if(argc < 3) {
        fprintf(stderr,"Usage : log-base <file> <command> [ <args> ]\n"); 
        exit(EXIT_FAILURE);
    }

    int tst;
    tst = pipe(pipe_1);
    verifier(tst==0,"Ouverture pipe1");
    tst = pipe(pipe_2);
    verifier(tst==0,"Ouverture pipe2");

    int ch1 = fork();
    if(ch1 == 0){
        close(pipe_1[R]);
        close(pipe_2[W]);
        close(pipe_2[R]);
        dup2(pipe_1[W],STDOUT_FILENO);
        char command[MAXLN];
        strcpy(command,argv[2]);
        for(int i = 3; i < argc; i++){
            strcat(command, " ");
            strcat(command,argv[i]);
        }
        system(command);
    }
    else{
        int st;
        waitpid(ch1,&st,0);
        char buff[MAXLN];
        if(fork()){
            close(pipe_1[W]);
            close(pipe_2[R]);
            int fd = open(argv[1],O_WRONLY|O_CREAT|O_TRUNC,0666);
            verifier(fd!=-1,"Open fd");
            while(1){
                tee(pipe_1[R],pipe_2[W],MAXLN,0);
                int rd = read(pipe_1[R],&buff,MAXLN);
                if(rd==0){
                    break;
                }
                write(fd,&buff,MAXLN);
            }
            close(fd);
            close(pipe_1[R]);
            close(pipe_2[W]);
        }
        else
        {
            close(pipe_1[W]);
            close(pipe_1[R]);
            close(pipe_2[W]);
            while(1){
                int rd = read(pipe_2[R],&buff,MAXLN);
                if(rd==0){
                    break;
                }
                write(STDOUT_FILENO,&buff,MAXLN);
            }
            close(pipe_2[R]);

        }
        
    }
}

