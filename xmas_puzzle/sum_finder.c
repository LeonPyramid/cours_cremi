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
#include <sys/stat.h>
#include <fcntl.h>



#define BUF 10
#define FPATH "input01"

int retInt(FILE* fd){

    char num[BUF];
    fgets(num,BUF,fd);
    return atoi(num);
}

int numline(const char * restrict path){
    FILE* fd = fopen(path,"r");
    int cmpt = 0;
    char num[BUF];
    while(1){
        if(fgets(num,BUF,fd) == NULL){
            fclose(fd);
            return cmpt;
        }
        cmpt++;
    }
}


int main(int argc, char const *argv[])
{
    //int out = open("log",O_WRONLY | O_CREAT | O_TRUNC,0666);
    //dup2(out, STDOUT_FILENO);
    int line = numline(FPATH);
    printf("%d\n",line);
    FILE* fd1 = fopen(FPATH,"r");
    for(int i = 0; i <= line; i ++){
        int i1 = retInt(fd1);
        FILE* fd2 = fopen(FPATH,"r");
        for(int j = i + 1; j <= line; j ++){
            int i2 = retInt(fd2);
            FILE* fd3 = fopen(FPATH,"r");
            for( int k = j + 1; k <= line ; k++){
                if( i != j && j != k && i != k){
                    int i3 = retInt(fd3);
                    //printf("%d + %d = %d\n",i1,i2,(i1 + i2));
                    if((i1 + i2 + i3) == 2020){
                        printf("%d * %d * %d= %d\n",i1,i2,i3,(i1 * i2 * i3));
                    }
            }
            }
            fclose(fd3);
        }
        fclose(fd2);
    }
    fclose(fd1);

    return 0;
}
