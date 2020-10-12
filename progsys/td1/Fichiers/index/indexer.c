#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/uio.h>
#include <unistd.h>

#define SUFFIXE ".idx"
#define BUF_SIZE 2048

void verifier(int cond, char *s) {
  if (!cond) {
    perror(s);
    exit(EXIT_FAILURE);
  }
}

int main(int argc, char *argv[]) {
  verifier(argc == 2, "il faut un paramètre.");

  // construire le chemin au fichier index
  int l = strlen(argv[1]);
  char idx_filename[l + strlen(SUFFIXE) + 1];
  strncpy(idx_filename, argv[1], l);
  strcpy(idx_filename + l, SUFFIXE);

  int fi = open(argv[1],O_RDONLY);
  verifier(fi,"erreur ouverture ficher à lire\n");
  int fo = open(idx_filename, O_WRONLY + O_CREAT + O_TRUNC,0666);
  verifier(fi,"erreur ouverture ficher à écrire\n");
  while(1){
    char buf;
    int i = read(fi,&buf,1);
    if(i == 0){
      break;
    }
    if(buf == '\n'){
      off_t off = lseek(fi,0,SEEK_CUR);
      int j = write(fo,&off,sizeof(off_t));
    }
  }

  close(fo);
  close(fi);
  return EXIT_SUCCESS;
}
