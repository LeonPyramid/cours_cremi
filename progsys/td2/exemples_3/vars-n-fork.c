#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

#define pprintf(format, ...) printf ("[PID %d] " format, getpid(), ##__VA_ARGS__)

int i = 5;

int main (int argc, char *argv[])
{
  pid_t pid;

  pid = fork ();
  if (pid) { // father
    pprintf ("Parent: i = %d\n", i);
    i = 6;
    sleep (2);
    pprintf ("Parent: i = %d\n", i);
  } else { // Child
    pprintf ("Child: i = %d\n", i);
    i=4;
    sleep (2);
    pprintf ("Child: i = %d\n", i);
  }

  return 0;
}
