#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>


//Pergunta 1

int main1 () {

    int x,maior=0;
    while (x!=0)
    {
        scanf ("%d",&x);
        if (x>maior) {maior=x;}
    }
    printf ("%d\n", maior);

    return 0;
}

//Pergunta 2

int main2 () {

    int x,i=0,media,soma=0;
    while (x!=0)
    {
        scanf ("%d",&x);
        i++;
        soma = soma+x;
        media = soma/i;
    }
    printf ("%d\n", media);

    return 0;
}

//Pergunta 3

int main3 () {

    int x,maior=0,segundomaior=0;
    while (x!=0)
    {
        scanf ("%d",&x);
        if (x>maior) {segundomaior = maior;
                      maior = x;
                     }
        else if  (x>segundomaior) {segundomaior=x;}
    }
    printf ("%d\n", segundomaior);

    return 0;
}

//Pergunta 4

int main4 () 
{
    unsigned int n;
    scanf ("%d", &n);
    int r=0;
    while (n/2!=1) {
    if (n%2==1) r++;
    n = n/2;
    if (n==3) r = r+2;
    }
    printf ("%d\n",r);


    return 0;
}


//Pergunta 5

int main5 () 
{
    unsigned int n;
    scanf ("%d",&n);
    if(n % 2) return 0;
    else return 1 + main5(n >> 1);
}

// Pergunta 6

int main6 () {
    int n;
    scanf("%d",&n);
    int r = 1;
    int temp = n;
    for (int i=0;temp/10!=0 && temp/10!=1;i++) {
        temp = temp/10;
        r++;
    }
    printf ("%d\n",r);
    return r;
}

// Pergunta 7

char *strcat1 (char s1[], char s2[]) {
    char *s3;
    s3 = malloc(sizeof(strlen(s1)+strlen(s2)-1));
    int j1=0,j2=0;
    
    for (int i=0;i<strlen(s1)+strlen(s2);i++) {
      if (i<strlen(s1))
      {
        s3[i]=s1[j1];
        j1++; 
      }
      else {
        s3[i]=s2[j2];
        j2++;
      }
    }
    
    s3[strlen(s1)+strlen(s2)] = '\0';
    
    s1=s3;

    return s1;
}

//Pergunta 9

int strcmp1 (char s1[], char s2[]) {
    int r=0;
    if (strlen(s1)<strlen(s2)) r=-1;
    else if (strlen(s2)<strlen(s1)) r=1;
    else {
        for (int i=0; i<strlen(s1);i++) {
            if (s1[i]==s2[i]);
            else {r=i;break;}
        }
    }
    return r;
}

//Pergunta 10

char *strstr1 (char s1[], char s2[])
{
    for (int i=0;i<strlen(s1);i++) 
    {
        if (s1[i]==s2[0]) 
        {
            int j=i+1;
            int s=1;
            while(s<strlen(s2)) 
            {
                if (s1[j]==s2[s]) {j++; s++;}
            }
        }
    } 
    return s1;
}

//Pergunta 11 

void strrev (char s[]) {
    char *t;
    int aux =strlen(s)-1;
    t = malloc(sizeof(strlen(s)));
    for (int i=0;i<sizeof(strlen(s));i++,aux--) {
        t[i]=s[aux];
    }
    t[strlen(s)] = '\0';
}

//Pergunta 12

void strnoV (char s[]) {
    char *aux = malloc(sizeof(strlen(s)));
    int j=0;
    for (int i=0;i<strlen(s);i++) {
        if (s[i]!='a'&& s[i]!='e'&& s[i]!='i'&& s[i]!='o'&& s[i]!='u') {aux[j]=s[i];j++;}
    }
    aux[j]='\0';
    s=aux;
}

//Pergunta 14

char charMaisfreq (char s[]) {
    char Maisfreq;
    int Mfreq=0;
    int freq=1;
    for (int i=0;s[i]!='\0';i++) {
        for (int j=i+1;s[j]!='\0';j++) if (s[i]==s[j]) {freq++;}
        if (freq>Mfreq) {Mfreq=freq; Maisfreq=s[i]; freq=1;}
    }
    return Maisfreq;
}

//Pergunta 26
void insere(int v[], int N, int x){
    int i, j;
    for(i = 0; i < N+1; i++){
        if(x < v[i]){
            for(j = N+1; j > i; j--){
                v[j] = v[j-1];
            }
            v[i] = x;
            break;
        }
    }
    printf("A lista resultante é \n");
    for(int i=0;i<N+1;i++) printf("%d ", v[i]);
    printf("\n");
}

//Pergunta 27

void ordena(int r[],int nr) {
    int temp;
    for(int i=0;i<nr;i++) {
        for (int j=i+1;j<nr;j++) 
        {
          if (r[i]>r[j]) {
            temp = r[i];
            r[i] = r[j];
            r[j] = temp;
          }
        }
    }
}

void merge (int r [], int a[], int b[], int na, int nb) {
    int nr=na+nb;
    for (int i=0;i<na;i++) {
        r[i]=a[i];
    }
    for (int i=na,j=0;i<nr;i++,j++) {
        r[i] = b[j]; 
    }
    ordena(r,nr);

    printf("A lista resultante é \n");
    for(int i=0;i<nr;i++) printf("%d ", r[i]);
    printf("\n");
}

//Pergunta 28

int crescente (int a[], int i, int j) {
    int r;
    for(;i<j;i++) {
        if (a[i]<a[i+1]) r=1;
        else r=0;break;
    }
    if(r==1) printf("Está ordenado.\n");

    else printf("Não está ordenado.\n");

    return r;
}

//Pergunta 29

int retiraNeg (int v[], int N) {
    int temp;
    for (int i=0;i<N;i++) {
        if (v[i]<0) {
            for (int j=i+1;j<N;j++) 
            {
                v[j-1]=v[j];
            }
           N--; 
        }
    }
    printf("A lista resultante é \n");
    for(int i=0;i<N;i++) printf("%d ", v[i]);
    printf("\n");
}

//Pergunta 30

int menosFreq (int v[], int N) {
    int freq=0;
    int freqmfreq=0;
    int mfreq;
    for (int i=0;i<N;i++) {
        for (int j=0;j<N;j++) {if (v[i]==v[j]) freq++;}
        if (freq<=freqmfreq) {freqmfreq = freq;mfreq=v[i];}
        else if (freqmfreq==0) {freqmfreq=freq;mfreq=v[i];}
        freq=0;
    }
    printf("O int menos frequente é o %d.\n", mfreq);
    return mfreq;
}


//Pergunta 47

typedef enum movimento 
{Norte, Oeste, Sul, Este} Movimento;


typedef struct posicao 
{int x, y;} Posicao;

Posicao posFinal (Posicao inicial, Movimento mov[], int N) {
    for (int i=0;i<=N;i++) {
        switch (mov[i])
        {
        case Norte: inicial.y++;break;
        case Sul:   inicial.y--;break;
        case Este:  inicial.x--;break;
        case Oeste: inicial.x++;break;
        
        default:break;
        }
    }
    printf("x=%d\ny=%d\n",inicial.x,inicial.y);
    return inicial;
}

//Pergunta 48

int caminho (size_t N) {
    Posicao inicial, final;
    printf ("Imprima a posição onde pretende iniciar: ");
    scanf("%d %d", &inicial.x, &inicial.y);
    printf ("Imprima a posição onde pretende terminar: ");
    scanf("%d %d", &final.x, &final.y);
    Movimento *mov=malloc(sizeof(N)); 
    int r;
    int resx = final.x-inicial.x;
    int resy = final.y-inicial.y;
    int control=0;
    if (resx!=0) {
    for (int i=0;i<=abs(resx);i++) {
        if (control>N) r=-1;
        else if (resx<0) {int j=0; while(final.x!=inicial.x) mov[j]=Oeste; j++;control++;}
        else {int j=0; while(final.x!=inicial.x) mov[j]=Este; j++;control++;}
    }
    }
    else if (resy!=0) {
     for (int i=0;i<=abs(resy);i++) {
        if (control>N) r=-1;
        if (resy<0) {int j=0; while(final.x!=inicial.x) mov[j]=Norte; j++;control++;}
        else {int j=0; while(final.x!=inicial.x) mov[j]=Sul; j++;control++;}
    }
    }
    printf("Movimentos;\n");
    for (int i=0;i<N;i++) {
        printf("%d ", mov[i]);
    }
    return r;
}




//main

int main () {
    int v[10] = {1,2,3,4,5,6,8,9,10,11};
    int b[5] = {1,2,3,4,5};
    int negs[5] = {-1,2,-3,4,5};
    int freq[6]= {1,1,2,2,4,1};
    int array[15];
    Posicao pos;
    Movimento mov[2]={Norte,Este};
    pos.x=pos.y=0;
    int r;
    scanf ("%d",&r);
    switch (r)
    {
    case 1 : main1(); break;
    case 2 : main2(); break;
    case 3 : main3(); break;
    case 4 : main4(); break;  
    case 5 : main5(); break;  
    case 6 : main6(); break; 
    case 10: strstr("ola meus","meus"); 
    case 26: insere(v,10,7);break;
    case 27: merge(array,v,b,10,5);break;
    case 28: crescente(b,0,3);break;
    case 29: retiraNeg(negs,5);break;
    case 30: menosFreq(freq,6);break;
    case 47: posFinal(pos,mov,2);break;
    case 48: caminho(30);break;

    
    default:break;
    }
    return 0;
}
