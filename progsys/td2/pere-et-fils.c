#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>



void verifier(int i, char *s)
{
  if (!i) {
    perror (s);
    exit (EXIT_FAILURE);
  }
}

int main(int argc, char const *argv[])
{
    pid_t f = fork();
    int t;
    if(f==0){
        printf("ahg");
        waitpid(getppid(),&t,0);
        printf("oh");
        }
    printf("je m'appelle %d et je suis le ",getpid());
    if(f == 0){
        printf("fils de %d\n",getppid());
    }
    else{
        printf("père de %d\n",f);
    }
    return 0;
}
