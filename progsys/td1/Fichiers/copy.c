#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

#include "error.h"

void verifier(int cond, char *s) {
  if (!cond) {
    perror(s);
    exit(EXIT_FAILURE);
  }
}

int main(int argc, char **argv) {
  if (argc != 4) {
    fprintf(stderr, "Erreur: pas bon nombre arguments!\n");
    return EXIT_FAILURE;
  }
  int cmpt = atoi(argv[3]);
  char c[cmpt];
  int n;
  int inf = open(argv[1], O_RDONLY);
  check(inf, "Cannot open %s", argv[1]);
  int ouf = open(argv[2], O_WRONLY | O_CREAT | O_TRUNC, 0666);
  check(ouf, "Cannot open %s", argv[2]);
  while (1) {
    n = read(inf, c, cmpt);
    if (n == 0) {
      close(inf);
      close(ouf);
      return EXIT_SUCCESS;
    }
    n = write(ouf, c, n);
    verifier(n, "");
  }
  return EXIT_SUCCESS;
}
