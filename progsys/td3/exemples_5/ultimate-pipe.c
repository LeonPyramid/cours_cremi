#include <ctype.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#include "error.h"

char *FILENAME = "file.txt";

#define pprintf(format, ...)                                                   \
  printf ("[PID %d] " format, getpid (), ##__VA_ARGS__)

int tube[2];

enum { R, W };

void child (void)
{
  close (tube[W]); // I won't write

  dup2 (tube[R], STDIN_FILENO); 
  close (tube[R]);

  execl ("/usr/bin/tr", "tr", "a-z", "A-Z", NULL);
  perror ("execl");
  exit (EXIT_FAILURE);
}

void father (void)
{
  close (tube[R]); // I won't read

  dup2 (tube[W], STDOUT_FILENO);
  close (tube[W]);

  execl ("/bin/cat", "cat", "-n", FILENAME, NULL);
  perror ("execl");
  exit (EXIT_FAILURE);
}

int main (int argc, char *argv[])
{
  if (argc > 1)
    FILENAME = argv[1];

  pipe (tube);

  if (fork () == 0) { // Child 1
    father ();
  }
  
  if (fork () == 0) { // Child 2
    child ();
  }

  close (tube[R]); close (tube[W]);

  wait (NULL); wait (NULL);

  return 0;
}
