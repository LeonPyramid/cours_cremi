#define XOPEN_SOURCE 600

#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <string.h>

#define NSIGNORT 32

sig_t masque;

struct sigaction sa;

void print_h(int id){
  printf("i got sig: %s\n",strsignal(id));
}
void qui_fait_rien(int _){}

int emetteur(int pere, int argc, char * argv[]) {
  int k = atoi(argv[1]);
  struct sigaction end;
  sigemptyset(&end.sa_mask);
  end.sa_flags = 0;
  end.sa_handler = qui_fait_rien;
  sigaction(SIGUSR1,&end,NULL);
  sleep(1);
  for(int i = 0 ; i < k ; i++){
    for(int j = 2; j < argc; j++){
      kill(pere,atoi(argv[j]));
      pause();
    }
  }
  kill(pere,9);
  return 0;
}



int recepteur(int fils) {
  printf("récepteur : %d\n", getpid());
  sa.sa_flags=0;
  sigemptyset(&sa.sa_mask);
  sa.sa_handler = print_h;
    // installation du handler pour tous les signaux non RT  
  for(int sig = 0 ; sig < NSIGNORT ; sig++) {
    sigaction(sig,&sa,NULL);
  }

  while(1){
    pause();
    kill(fils,SIGUSR1);
  }
  return 0;
}


int main(int argc, char *argv[]){

  pid_t pid = fork();  
  if (pid == 0)
    emetteur(getppid(),argc,argv);
  else
    recepteur(pid);  
}
