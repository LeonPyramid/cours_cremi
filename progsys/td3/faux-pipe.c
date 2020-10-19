#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>

void verifier(int i, char *s)
{
  if (!i) {
    perror (s);
    exit (EXIT_FAILURE);
  }
}

int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}
