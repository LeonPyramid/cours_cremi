#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>


void verifier(int i, char *s)
{
  if (!i) {
    perror (s);
    exit (EXIT_FAILURE);
  }
}

void quelques_prints (void)
{
  printf ("Juste");
  printf (" histoire");
  printf (" de tester...\n");
  printf ("...que la redirection");
  printf (" marche !\n");
}

void rediriger_vers (void (*f)(void), char *file)
{
  int nout = open(file, O_WRONLY | O_TRUNC | O_CREAT , 0666);
  verifier(nout!=-1,"pas ouvert");
  int tmp = dup(STDOUT_FILENO);
  dup2(nout,STDOUT_FILENO);
  f();
  dup2(tmp,STDOUT_FILENO);
  close(nout);
}

int main(int argc, char *argv[])
{
  printf ("*** DEBUT ***\n");

  rediriger_vers (quelques_prints, "sortie.txt");

  printf ("*** FIN ***\n");

  return EXIT_SUCCESS;
}
  
