#include <stdio.h>

typedef struct slist {
    int valor;
    struct slist *prox;
} *LInt;

typedef struct nodo {
    int valor;
    struct nodo *esq, *dir;
} *ABin;

int retiraNeg (int v[], int N) 
{
    int temp;
    for (int i=0;i<N;i++) 
    {
        if (v[i]<0) 
        {
            for (int j=i;j<N;j++) 
            {
                v[j] = v[j+1];
            }
            N--;
        }
    }
    return N;
}

int difConsecutivos (char s[]) 
{
    int accumtemp=0;
    int accum =0;

    for (int i=0;s[i]!='\0';i++) 
    {
        if (s[i]!=s[i+1]) accumtemp++;
        else accumtemp=0;
        if (accumtemp>accum) accum=accumtemp;
    }
    
    
    return accum;

}

int maximo (LInt l) 
{
    int max=l->valor;

    while (l->prox!=NULL) 
    {
        if (max<l->prox->valor) max = l->prox->valor;
        l = l->prox;
    }
    return max;
}

int removeAll (LInt *l, int x) 
{
    int ocorr=0;

    while (*l) 
    {
        if ((*l)->valor==x) {
            LInt aux = (*l);
            (*l) = (*l)->prox;
            (*l)->prox=(*l)->prox->prox;ocorr++;}
        (*l) = (*l)->prox;
    }
    return ocorr;
}

LInt arrayToList (int v[], int N) 
{    
    if(!N) return NULL;
    LInt l = malloc(sizeof(struct slist));

    l->valor=*v;
    l->prox=arrayToList(v+1,N-1);
    
    return l;
}



int main () 
{
    int v[] = {1,-1,2,3};
    printf ("%d\n",retiraNeg(v,4));

    printf ("%d\n",difConsecutivos ("aaabcaa"));

    return 0;
}