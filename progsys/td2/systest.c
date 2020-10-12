#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>

#include "error.h"


void verifier(int i, char *s)
{
  if (!i) {
    perror (s);
    exit (EXIT_FAILURE);
  }
}

void System(char *commande);

int main(int argc, char const *argv[])
{
    System("ls -l");
}




void System(char *commande){
    int f = fork();
    if(f == 0){
        execl("/bin/sh", "sh", "-c", commande, NULL);
    }
    else{
        int exitst;
        waitpid(f,&exitst,0);
    }

}