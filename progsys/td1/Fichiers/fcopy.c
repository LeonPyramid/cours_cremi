#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

#include "error.h"

void verifier(void* cond, char *s) {
  if (cond == NULL) {
    perror(s);
    exit(EXIT_FAILURE);
  }
}

int main(int argc, char **argv) {
  if (argc != 3) {
    fprintf(stderr, "Erreur: pas bon nombre arguments!\n");
    return EXIT_FAILURE;
  }
  char c;
  int n;
  FILE * inf = fopen(argv[1], "r");
  verifier(inf,"");
  FILE * ouf = fopen(argv[2], "w");
  verifier(ouf,"");
  while (1) {
    n = fread(&c, sizeof(char),1,inf);
    if (n == 0) {
      fclose(inf);
      fclose(ouf);
      return EXIT_SUCCESS;
    }
    n = fwrite(&c, sizeof(char), 1, ouf);
  }
  return EXIT_SUCCESS;
}
