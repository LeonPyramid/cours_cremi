#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <string.h>

#define pprintf(format, ...) printf ("[PID %d] " format, getpid(), ##__VA_ARGS__)

void my_sig_handler (int sig)
{
  pprintf ("I received signal %s\n", strsignal (sig));
}

int main (int argc, char *argv[])
{
  struct sigaction sa;

  pprintf ("Main engages in infinite loop\n");

  sa.sa_flags = 0;
  sigemptyset (&sa.sa_mask);
  sa.sa_handler = my_sig_handler;

  sigaction (SIGINT, &sa, NULL);

  while (1) ;

  return 0;
}
