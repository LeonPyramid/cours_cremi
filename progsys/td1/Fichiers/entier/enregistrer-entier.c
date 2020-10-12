#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

u_int32_t empty = 0;

#include "../error.h"

void verifier(int cond, char *s) {
  if (!cond) {
    perror(s);
    exit(EXIT_FAILURE);
  }
}

void main(int argc,char** argv){

    if (argc != 4){
        fprintf(stderr,"Erreur: paq bon nombre argu!\n");
        exit(EXIT_FAILURE);
    }
    
    char* NOM_FICHIER = argv[1];
    int pos = atoi(argv[2]);
    u_int32_t val = atoi(argv[3]);

    int fd = open (NOM_FICHIER, O_WRONLY );
    check (fd, "Cannot open %s file", NOM_FICHIER);

    if(pos > 0){
        int off = lseek(fd,pos*sizeof(u_int32_t),SEEK_CUR);
        check(off,"");
    }

    int v = write(fd,&val,sizeof(u_int32_t));
    check(v,"");
    
    close(fd);
    return EXIT_SUCCESS;
}