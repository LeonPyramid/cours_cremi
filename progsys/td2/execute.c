#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>

#include "error.h"
#define maxlen 256



void verifier(int i, char *s)
{
  if (!i) {
    perror (s);
    exit (EXIT_FAILURE);
  }
}

void System(char * command);

int main(int argc, char const *argv[])
{
    verifier(argc>=2,"Usage : execute command list-of-param");
    //transformation des paramètres

    char dest[maxlen];

    strcpy( dest,"");
    for(int i = 1; i<argc-1; i++){
      strcat( dest, argv[i]);
      strcat( dest, " ");
    }
    strcat( dest, argv[argc-1]);
    strcat( dest, "");
    //appel de la fonction (avec un cast pour éviter les warnings)
    System(dest);
    return 0;
}




void System(char * command){
    printf("*** execution\n");
    int f = fork();
    if(f == 0){
        execlp("/bin/sh", "sh", "-c", command, NULL);
    }
    else{
        int exitst;
        waitpid(f,&exitst,0);
        printf("*** code de retour : %d\n",exitst);
    }

}