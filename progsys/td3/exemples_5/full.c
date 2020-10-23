#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include "error.h"

#define SIZE 32

int main (int argc, char *argv[])
{
  int r;
  char c[SIZE];
  int cumul = 0;

  int tube[2];

  pipe (tube);

  for (;;) {
    alarm (1);
    r = write (tube[1], c, SIZE);
    check (r, "write");
    alarm (0);
    cumul += r;
    printf ("%d bytes written\n", cumul);
  }

  close (tube[1]);

  return 0;
}