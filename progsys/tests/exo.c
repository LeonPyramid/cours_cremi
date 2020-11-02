#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <sys/types.h>

struct node { void * data; struct node * left; struct node * right; };

typedef struct node nodes;

void mystere(struct node * node, void (*fun)(void *)) {
  int p[2];
  pipe(p);
  int flags = fcntl(p[0], F_GETFL, 0);
  fcntl(p[0], F_SETFL, flags | O_NONBLOCK);
  write(p[1], &node, sizeof(struct node *));
  while(read(p[0], &node, sizeof(struct node *)) > 0) {
    fun(node->data);
    struct node * left = node->left;
    struct node * right = node->right;    
    if(left) write(p[1], &left, sizeof(struct node *));
    if(right) write(p[1], &right, sizeof(struct node *));
  }
  close(p[0]); close(p[1]);
}