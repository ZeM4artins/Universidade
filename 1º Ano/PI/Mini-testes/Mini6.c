#include <stdlib.h>
#include <stdio.h>

typedef struct nodo {
    int valor;
    struct nodo * prox;
} *LInt;


int calcula(LInt l) {
    int conta = 0;
    int r = 0;

    while (conta <= 3)
    {
        if (conta % 2 == 1)
        {
            r += l->valor;
        }
        l = l->prox;

        conta ++;
    }
    return r;
}


int main () {
    LInt (*a) = malloc(sizeof(struct nodo));
    (*a)->valor=0;
    (*a)->prox->valor=1;
    (*a)->prox->prox->valor=0;
    (*a)->prox->prox->prox->valor=2;
    printf("%d",calcula(*a));
    return 0;

}
