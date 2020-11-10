#define _GNU_SOURCE

#include <sys/wait.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <string.h>
#include <signal.h>
#include <sys/time.h>

struct sigaction sa, old;

void my_sighandler(int id){
    printf("cltr-c\n");
    sigaction(SIGINT,&old,NULL);
}

int main(int argc, char const *argv[])
{
    sa.sa_flags = 0;
    sigemptyset (&sa.sa_mask);
    sa.sa_handler = my_sighandler;

    sigaction (SIGINT,&sa,&old);

    while(1){

    }

    return 0;
}
