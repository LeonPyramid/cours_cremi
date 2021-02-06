#include "tsp_brute_force.h"

//
//  TSP - BRUTE-FORCE
//
// -> la structure "point" est définie dans tools.h

double dist(point A, point B) {
  return sqrt(pow((B.x-A.x),2)+pow((B.y-A.y),2));
}

double value(point *V, int n, int *P) {
  int val = dist(V[P[0]],V[P[n-1]]);
  for (int i  = 0; i < n; i++){
    val += dist(V[P[i]],V[P[i+1]]);
  }
  return val;
}

int* initPerm( int n ){
  int *tab = malloc(n*sizeof(int));
  for(int i = 0; i < n; i ++){
    tab[i] = i;
  }
  return tab;
}

double tsp_brute_force(point *V, int n, int *Q) {
  int* P = initPerm(n);
  double res = value(V,n,P);
  while(NextPermutation(P,n-1)){
    double nxt = value(V,n,P);
    if(nxt < res){
      res = nxt;
      memcpy(Q,P,n*sizeof(int));
    }
  }
  return res;
}

void printTab(int* P, int n){
  printf("[ ");
  for (int i = 0; i < n; i ++){
      printf("%d ",P[i]);
  }
  printf("]\n");
}

void MaxPermutation(int *P, int n, int k) {
  for(int i = 0; i < (n-k)/2; i ++){
    if(k+i >= n){
      fprintf(stderr,"Erreur : hors du tableau, k = %d, n = %d, i = %d\n",k,n,i);
      break;
    }
    if(k+i != n-i-1){
      int tmp = P[k+i];
      P[k+i] = P[n-i-1];
      P[n-i-1] = tmp;
    }
  }
}

double value_opt(point *V, int n, int *P, double w) {
  double res = dist(V[P[0]],V[P[n-1]]);
  for (int i = 0; i<n-1; i++){
    res += dist(V[P[i]],V[P[i+1]]);
    if (res  >= w){
      return - (i+2);
    }
  }
  return res;
  return 0;
}

double tsp_brute_force_opt_old(point *V, int n, int *Q) {
  int* P = initPerm(n);
  double res = value(V,n,P);
  while(NextPermutation(P,n-1)){
    double nxt = value(V,n,P);
    if(nxt < res){
      res = nxt;
      memcpy(Q,P,n*sizeof(int));
    }
  }
  return res;
}

double tsp_brute_force_opt(point *V, int n, int *Q){
  int* P = initPerm(n);
  double res = value(V,n,P);
  while(NextPermutation(P,n-1)){
    double nxt = value_opt(V,n,P,res);
    if(nxt < 0){
      MaxPermutation(P,n-1,-nxt);
    }
    else if(nxt < res){
      res = nxt;
      memcpy(Q,P,n*sizeof(int));
    }
  }
  return res;
}