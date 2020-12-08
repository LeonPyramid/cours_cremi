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

#define BUF 100000000

int retInt(FILE* fd){
    char num[BUF];
    fgets(num,BUF,fd);
    return atoi(num);
}

int numline(char *  path){
    FILE* fd = fopen(path,"r");
    int cmpt = 0;
    char num[BUF];
    while(1){
        if(fgets(num,BUF,fd) == NULL){
            fclose(fd);
            printf("%d\n",cmpt);
            return cmpt;
        }
        cmpt++;
    }
}

void outRedir(char* path){
    int out = open(path,O_WRONLY | O_CREAT | O_TRUNC,0666);
    dup2(out, STDOUT_FILENO);
}
