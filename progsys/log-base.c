#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <string.h>

#define MAXLN 1024

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

    int ch = fork();
    if(ch == 0){
        int fd = open(argv[1],O_WRONLY|O_CREAT|O_TRUNC,0666);
        verifier(fd!=-1,"Open fd");
        dup2(fd,STDOUT_FILENO);
        char command[MAXLN];
        strcpy(command,argv[2]);
        for(int i = 3; i < argc; i++){
            strcat(command, " ");
            strcat(command,argv[i]);
        }
        system(command);
    }
    else{
        int stat;
        waitpid(ch,&stat,0);
        execlp("/usr/bin/cat","cat",argv[1],NULL);
    }
}

