#include "heap.h"
#include <stdlib.h>

heap heap_create(int k, int (*f)(const void *, const void *)) {
  
  heap newHeap = malloc(sizeof(*newHeap));
  newHeap->nmax = k;
  newHeap->f = f;
  newHeap->n =0;
  newHeap->array = malloc ((k+1) * sizeof(void *));
  return newHeap;
}

void heap_destroy(heap h) {
  free(h->array);
  free(h);
}

bool heap_empty(heap h) {
  if (h->n != 0){
    return false;
  }
  return true;
}

bool heap_add(heap h, void *object) {
  if (h->n==h->nmax)
  {
   return true; 
  }
  else{
    (h->n)++;
    int i=h->n;
    h->array[i]=object;
    while (i>1 && h->f(h->array[i],h->array[i/2])<=0 )
    {
      void* tmp = h->array[i];
      h->array[i]=h->array[i/2];
      h->array[i/2]=tmp;
      i=i/2;
    }
    return false;
  }
}

void *heap_top(heap h) {
  if (heap_empty(h))
  {
    return NULL;
  }
  return h->array[1];
}

void *heap_pop(heap h) {
  if (heap_empty(h))
  {
    return NULL;
  }
  void *res=h->array[1];
  h->array[1]=h->array[h->n];
  (h->n)--;
  int n=h->n; 
  int i=1;
  while ((2*i<=n && h->f(h->array[i],h->array[2*i])>=0) || ((2*i+1)<=n && ((h->f(h->array[i],h->array[2*i+1])>=0) || h->f(h->array[i],h->array[2*i])>=0)))
  {
   int j=0;
   if (((2*i+1)<=n) && (h->f(h->array[2*i],h->array[2*i+1])>0))
      j=2*i+1;
    else{
      j=2*i;
    }
   if (h->f(h->array[i],h->array[j])>=0)
   {
      void* tmp = h->array[i];
      h->array[i]=h->array[j];
      h->array[j]=tmp;
   }
   i=j;
  }
  return res;
}