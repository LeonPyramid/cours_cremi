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
  int tube [2];

  pipe (tube);

  close (tube[0]);

  ecrire (tube[1], message, strlen(message));

  printf ("Et voilà\n");

  return 0;
}