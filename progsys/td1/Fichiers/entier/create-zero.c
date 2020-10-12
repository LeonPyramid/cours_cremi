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

    if (argc != 3){
        fprintf(stderr,"Erreur: paq bon nombre argu!\n");
        exit(EXIT_FAILURE);
    }
    
    char* NOM_FICHIER = argv[1];
    int nbz = atoi(argv[2]);

    int fd = open (NOM_FICHIER, O_WRONLY | O_CREAT | O_TRUNC, 0666 );
    check (fd, "Cannot open %s file", NOM_FICHIER);

    for(int i = 0; i < nbz; i++){
        int v = write(fd,NULL,sizeof(u_int32_t));
        check(fd,"");
    }

    close(fd);
    return EXIT_SUCCESS;
}