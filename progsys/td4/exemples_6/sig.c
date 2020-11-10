#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <signal.h>
#include <string.h>

#define pprintf(format, ...) printf ("[PID %d] " format, getpid(), ##__VA_ARGS__)

int main (int argc, char *argv[])
{
  pid_t pid;

  pid = fork ();
  if (pid) { // father
    int status;

    //sleep (1);
    //kill (pid, SIGTERM);

    wait (&status);

    if (WIFSIGNALED(status)) {
      int sig = WTERMSIG(status);
      pprintf ("Child killed by signal %s\n", strsignal (sig));
    } else {
      pprintf ("Child exited normally (code: %d)\n", WEXITSTATUS (status));
    }

  } else { // Child
    pprintf ("Child start\n");

    //alarm(1);
    //int *ptr = NULL;
    //*ptr = 12;
    //abort ();
    //raise (SIGUSR1);
    //int i = 5, j = 0;
    //pprintf ("Division by zero : %d\n", i / j);
    int tube[2]; pipe(tube); close (tube[0]); write (tube[1], tube, 8);

    sleep(2);
    pprintf ("Child end\n");
  }

  return 0;
}
