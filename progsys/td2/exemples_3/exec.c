#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main (int argc, char *argv[])
{

  printf ("I am about to become \"ls -l\"\n");

  execl ("/bin/ls", "ls", "-l", "exemples_1", NULL);
  perror ("execl");

  return EXIT_FAILURE;
}
