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

  for (;;) {
    char c;
    int n = read (STDIN_FILENO, &c, 1);
    check (n, "Cannot read");
    if (n == 0)
      break;
    if (isalpha(c)) {
      c = toupper (c);
    }
    n = write (STDOUT_FILENO, &c, 1);
    check (n, "Cannot write");
  }
}

void father (void)
{
  int newline = 1;
  int line = 1;
  char str[16];

  close (tube[R]); // I won't read

  dup2 (tube[W], STDOUT_FILENO);
  close (tube[W]);

  int fd = open (FILENAME, O_RDONLY);
  check (fd, "Cannot open %s file", FILENAME);

  dup2 (fd, STDIN_FILENO); close (fd);

  for (;;) {
    char c;
    int n = read (STDIN_FILENO, &c, 1);
    check (n, "Cannot read from file %s", FILENAME);
    if (n == 0)
      break;
    if (newline) {
      snprintf (str, 16, "\t%d  ", line);
      write (STDOUT_FILENO, str, strlen (str));
      newline = 0;
    }
    n = write (STDOUT_FILENO, &c, 1);
    check (n, "Cannot write");
    if (c == '\n') {
      line++;
      newline = 1;
    }
  }
}

int main (int argc, char *argv[])
{
  if (argc > 1)
    FILENAME = argv[1];

  pipe (tube);

  if (fork ()) { // father
    father ();
  } else { //child
    child ();
  }

  return 0;
}
