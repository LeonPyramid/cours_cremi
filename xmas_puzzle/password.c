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
//#include "func.h"

#define BUF 1000000
#define FPATH "input02"

int numline(char *  path){
    FILE* fd = fopen(path,"r");
    int cmpt = 0;
    char num[BUF];
    while(1){
        if(fgets(num,BUF,fd) == NULL){
            fclose(fd);
            //printf("%d\n",cmpt);
            return cmpt;
        }
        cmpt++;
    }
}

void outRedir(char* path){
    int out = open(path,O_WRONLY | O_CREAT | O_TRUNC,0666);
    dup2(out, STDOUT_FILENO);
}

int passwordTest(int min,int max, char tst, char* str){
    int exist = 0;
    int i = 0;
    while(1){
        char c = str[i];
        if(c == tst){
            if(i+1 == min || i+1 == max ){
                exist++;
            }
        }
        if(c == '\n' || c == '\0'){
            break;
        }
        i++;
    }
    return exist == 1 ;
}

int main(int argc, char const *argv[])
{

    //outRedir("log2");
    int valid = 0;
    int line = numline(FPATH);
    //printf("%d\n",line);
    FILE* fd = fopen(FPATH,"r");
    int min;
    int max;
    char tst;
    char txt[256];
    for ( int i = 0; i < line; i ++){
        fscanf(fd,"%d %d %c %s",&min,&max,&tst,txt);
        printf("%d - %d _ %c\n",min,max,tst);
        if(passwordTest(min,max,tst,txt)){
            valid ++;
        }
    }
    printf("%d\n",valid);
    fclose(fd);
    return 0;
}
