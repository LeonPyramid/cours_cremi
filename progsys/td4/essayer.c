
#define _GNU_SOURCE

#include <sys/wait.h>
#include <stdlib.h>
#include <unistd.h>
#include <stdio.h>
#include <sys/types.h>
#include <string.h>
#include <signal.h>
#include <sys/time.h>
#include <setjmp.h>
#include "essayer.h"
void f(void*p){}

int essayer(void (*f)(void*),void *p,int sig){
    
}


int main(){
int r; 
r = essayer(f,NULL, SIGSEGV);
if(r == 0)
    printf("L'exécution de f s'est déroulée sans problème\n");
else
    printf("L'exécution de f a échoué\n");
}