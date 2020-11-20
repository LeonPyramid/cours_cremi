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

typedef /* unspecified */ jmp_buf;
	


int main(int argc, char const *argv[])
{
   jmp_buf buf;
   //int i = 0;
   int r = 0;
   func(buf);
   printf("%d\n",r++);
   //i++;
    if(r < 10){
       //longjmp(buf,1);
       longjmp(buf,1);
    }
    return 0;
}

    void func (jmp_buf ctx){
        setjmp(ctx);
    }