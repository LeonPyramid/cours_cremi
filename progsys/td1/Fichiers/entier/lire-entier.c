#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

#include "../error.h"

#define errlog "ERREUR_LIRE.log"

void verifier(int cond, char *s) {
  if (!cond) {
    perror(s);
    exit(EXIT_FAILURE);
  }
}

int main(int argc, char const *argv[])
{
  //Changement destination erreur
  int ef = open(errlog,O_WRONLY | O_TRUNC | O_CREAT,0666);
  int oerr = STDERR_FILENO;
  int t = dup2(ef,STDERR_FILENO);

  if (argc != 3){
        fprintf(stderr,"Erreur: paq bon nombre argu!\n");
        exit(EXIT_FAILURE);
  }
  u_int32_t val;
  char* FILENAME = argv[1];
  int pos = atoi(argv[2]);
  int fd = open(FILENAME,O_RDONLY);
  check(fd,"erreur lecture:");
  int v;
  if(pos > 0){
        int off = lseek(fd,pos*sizeof(u_int32_t),SEEK_CUR);
        rcheck(off,"seek");
    }
  v = read(fd,&val,sizeof(u_int32_t));
  rcheck(v,"lecture");
  printf("%u\n",val);
  close(fd);
  return 0;
}
