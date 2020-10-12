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

int main(int argc, char *argv[]) {
  char c;
  int fd;
  if (argc > 1) {
    fd = open(argv[1], O_WRONLY | O_CREAT | O_TRUNC, 0666);
    check(fd, "Cannot open %s", argv[1]);
  }
  while (1) {
    int n = read(STDIN_FILENO, &c, 1);
    if (n == 0) {
      if (argc > 1) {
        close(fd);
      }
      return 0;
    }
    write(STDOUT_FILENO, &c, 1);
    if (argc > 1) {
      write(fd, &c, 1);
    }
  }
}