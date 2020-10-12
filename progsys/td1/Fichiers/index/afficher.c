#include <errno.h>
#include <fcntl.h> 
#include <sys/types.h>
#include <sys/uio.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define SUFFIXE ".idx"


void verifier(int cond, char *s){
  if (!cond){
    perror(s);
    exit(EXIT_FAILURE);
  }
}

int main(int argc, char *argv[]){
  verifier(argc == 3, "il faut deux paramètres.");

  // construire le chemin au fichier index
  int l = strlen(argv[1]) ;
  int line = atoi(argv[2])-1;
  char idx_filename[l + strlen(SUFFIXE) + 1];
  strncpy(idx_filename, argv[1], l);
  strcpy(idx_filename + l, SUFFIXE);

  int fi = open(argv[1],O_RDONLY);
  verifier(fi,"erreur ouverture ficher à lire\n");
  int idx = open(idx_filename, O_RDONLY,0666);
  verifier(fi,"erreur ouverture ficher à écrire\n");

  off_t enpos;
  int t;
  //Set start pos in fi
  if( line != 0){
    off_t off;
    t = lseek(idx,(line-1)*sizeof(off_t),SEEK_SET);
    t = read(idx,&off,sizeof(off_t));
    t = lseek(fi,off,SEEK_SET);
  }
  //Set end pos in enpos
  t = read(idx,&enpos,sizeof(off_t));
  verifier(t!=0,"pas dans l'index!");
  close(idx);


  while(1){
    char c;
    int i = read(fi,&c,1);
    off_t pos = lseek(fi,0,SEEK_CUR);
    if((i==0)||(pos>enpos)){
      break;
    }
    i = write(STDOUT_FILENO,&c,1);
  }

  close(fi);
  return EXIT_SUCCESS;
}
