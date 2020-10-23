#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include "error.h"

size_t ecrire (int fd, char *s, size_t n)
{
  int r = write (fd, s, n);
  check (r, "Cannot write into pipe");

  printf ("Wrote %d bytes", r);

  return r;
}

char *message = "Ceci est un message qui ne paie pas de mine, mais qui se "
                "révèle redoutablement long en pratique, sans toutefois "
                "atteindre non plus des proportions gigantesques...";

int main (int argc, char *argv[])
{
  int r;

  int tube [2];

  pipe (tube);

  r = ecrire (tube[1], message, strlen(message));

  close (tube[1]);

  for (;;) {
    char c;
    r = read (tube[0], &c, 1);
    check (r, "read");
    if (r == 0)
      break;
    write (1, &c, 1);
  }

  return 0;
}