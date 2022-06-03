#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct slist {

  int valor;
  struct slist * prox;
} *LInt;


LInt newLInt (int x, LInt xs) {
  LInt r = malloc (sizeof(struct slist));
  if (r!=NULL) {
    r->valor = x;
    r->prox = xs;
  }
  return r;
}

int sorted (LInt l) {
  int r = 1;
  while (l && r) {
     	

if (l->valor > l->prox->valor && l->prox) r = 0;


    l = l->prox;
  }
  return r;
}

LInt init (LInt l) {
  LInt a = NULL;
  LInt b = l;
  while (b->prox) {
    a = b;
    b = b->prox;
  }
   	

if (a) {free(b); a->prox = NULL; a = l;}

  
  return a;
}

int main() {
    LInt z=newLInt(3,newLInt (2,newLInt(1,NULL)));
    printf("%d\n",sorted(z));
    z = init(z);
    while (z->prox!=NULL) {
    z->prox;
    printf ("%d",z->valor);
    }

    return 0;
}


