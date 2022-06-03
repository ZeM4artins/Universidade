#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

typedef struct lligada {
    int valor;
    struct lligada *prox;
} *LInt;

LInt newLInt (int, LInt);
int length (LInt l);

//Pergunta 51

LInt newLInt (int v, LInt t){
    LInt new = (LInt) malloc (sizeof (struct lligada));
    
    if (new!=NULL) {
        new->valor = v;
        new->prox  = t;
    }
    return new;
}

int length(LInt l){
    int c = 0;
    while(l){
        c++;
        l = l->prox;
    }
    printf("%d\n",c);
    return c;
}

//Pergunta 52

void freeL(LInt l){
    LInt aux;
    while(l){
        aux = l->prox;
        free(l);
        l = aux;
    }
}

//Pergunta 53

void imprimeL (LInt l) {
    LInt aux = l;
    for(;aux!=NULL;aux=aux->prox) 
    {
        printf("%d\n",aux->valor);
    }
    free(aux);
}

//Pergunta 54

LInt reverseL (LInt l) {
    LInt back = NULL;
    LInt front;
    while (l) {
    front=l->prox;
    l->prox=back;
    back=l;
    l=front;
    }

    imprimeL(back);
    return back;
}

//Pergunta 55

void insertOrd (LInt *l, int x) {
    while (l && (*l)->valor>x && (*l)->prox->valor<x) l=&(*l)->prox;

    LInt temp = (*l)->prox;

    (*l) = malloc(sizeof(struct lligada));
    (*l)->prox->valor=x;
    (*l)->prox->prox=temp;

    imprimeL(*l);

}

//Pergunta 57

void merge(LInt* r, LInt a, LInt b) {
    if(a==NULL && b==NULL) return;
    if(b == NULL || a != NULL && a->valor < b->valor) {
        (*r) = a;
        merge(&((*r)->prox),a->prox,b);
    }
    else {
        (*r) = b;
        merge(&((*r)->prox),a,b->prox);
    }
}

//Pergunta 58

void splitQS (LInt l, int x, LInt *mx, LInt *Mx){
    if (l==NULL) return;
    else if (l->valor<x) {(*mx)=l; (*Mx)=NULL;splitQS(l->prox,x,&((*mx)->prox),Mx);}
    else {(*Mx)=l;(*mx)=NULL;splitQS(l->prox,x,mx,&(*Mx)->prox);}
}

//Pergunta 59


LInt parteAmeio (LInt *l){
    int i;
    int r = length(*l)/2;
    if (r==0) return NULL;
    LInt y = (*l);
    LInt inicio = NULL;
    
    for(i = 0; i < r; i++) {
        inicio = (*l);
        (*l) = (*l)->prox;
    }
    
    inicio->prox = NULL;
    
    return y;
}

//Pergunta 60

int removeAll (LInt *l, int x){
    int accum=0;
    if ((*l)==NULL);
    else if ((*l)->valor==x) {accum++;(*l)=(*l)->prox;accum+=removeAll(l,x);}
    else accum+=removeAll(&((*l)->prox),x);
    
    return accum;
}

//Pergunta 62






int main () {
    int r;
    scanf("%d",&r);
    LInt s = newLInt(10,newLInt(20,newLInt(30,NULL)));
    switch (r)
    {
    case 1:length(s);break;
    case 2:freeL(s);break;
    case 3:imprimeL(s);break;
    case 4:reverseL(s);break;
    
    default:
        break;
    }
}