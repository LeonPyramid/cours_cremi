#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>


#define file "./process-create"

void verifier(int i, char *s)
{
  if (!i) {
    perror (s);
    exit (EXIT_FAILURE);
  }
}

int main(int argc, char const *argv[])
{
    verifier(argc==2,"Usage: process-create <nubmer of process>\n");
    int n = atoi(argv[1]);
    char val;
    int exstat;
    if(n > 0){
        val = n-1+'0';
        int f = fork();
        if(f == 0){
          execlp(file,file,&val,NULL);
        }
        else{
          waitpid(f,&exstat,0);
          printf("%d\n",n);

        }
    }
    else{
      printf("0\n");
    }
    return 0;
}
