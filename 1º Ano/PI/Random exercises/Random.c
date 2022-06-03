#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>


void printstring() 
{ 
    char ch;
    char st[20];
    char sen[50];
    
    scanf ("%c", &ch);
    scanf ("%s", st);
    scanf ("\n");
    fgets (sen, sizeof(sen), stdin);

    printf ("%c\n", ch);
    printf ("%s\n", st);
    printf ("%s\n", sen);
}




int sumandifference (){

    int a, b;
    float c, d;

    scanf ("%d %d\n", &a, &b);
    scanf ("%f %f", &c, &d);

    int si, mi;
    si = a+b;
    mi = a-b;

    float sf, mf;
    sf = c+d;
    mf = c-d;

    printf ("%d %d\n", si, mi);
    printf ("%.1f %.1f\n", sf, mf);

    return 0;
}




int max_of_four(int a, int b, int c, int d) {
    
    // scanf ("%d\n %d\n %d\n %d", a,b,c,d);

    int greatest;

      if (a>b && a>c && a>d) {greatest = a;}
      else if (b>a && b>c && b>d) {greatest = b;}
      else if (c>a && c>b && c>d) {greatest = c;}
      else greatest = d;
      

    return greatest;
}


int main1 () { // A função anterior depende deste para ser corretamente executada
    int a, b, c, d;
    scanf("%d %d %d %d", &a, &b, &c, &d);
    int ans = max_of_four(a, b, c, d);
    printf("%d\n", ans);
    
    return 0;
}




void update(int *a,int *b) {

    *a = *a+*b; 
    *b = abs (*a-(2**b));

}

int main3 () {
    int a, b;
    int *pa = &a, *pb = &b;
    
    scanf("%d\n %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d\n", a, b);

    return 0;
}




int main4 () 
{
    int a, b;
    scanf("%d\n%d", &a, &b);
    
    char labels[11][6] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "even", "odd"};
    int labels_index;
  	for (int i=a; i<=b; i++) {
        labels_index = i <= 9 ? i - 1 : 9 + i % 2;
        printf("%s\n", labels[labels_index]);
    }

    return 0;
}




int main5 () {
	
    int n;
    scanf("%d", &n);
    int digit, sum = 0;
    while(n > 0)
    {
        digit = n % 10;
        sum = sum + digit;
        n = n / 10;
    }
    printf("%d\n",sum);
    return 0;
}


int main6 () {
    int x,y;
        for (y=0;y<8;y++) {    
        for (x=0;x<8;x++) {
             if (x + y < 8) putchar('#');
             else putchar('.');
  }
  putchar('\n');
}
return 0;
}


int main7 () {
  int x;
  scanf ("%d", &x);  
  int r = 0;
  while (x > 0) {
    r += 1;
    x = x - r;
  }
  printf ("%d\n", r);
  return 0;
}

// int main8() 
// {

//     int n,i,j;
//     scanf("%d", &n);
//     // a cada nr que passa são precisos mais dois espaços
    
//     for (int i = -n + 1; i < n; i++)
//     {
//         for (int j = -n + 1; j < n; j++)
//         {
//             printf("%d ", MAX(abs(i), abs(j)) + 1);
//         }
//         printf("\n");

//         return 0;
//     }
// }


int main9()
{
    int num, *arr, i;
    scanf("%d", &num);
    arr = (int*) malloc(num * sizeof(int));
    for(i = 0; i < num; i++) {
        scanf("%d", arr + i);
    }

    int mem;
    if (num%2==1) {
    for (i=0;i<(num-1)/2;i++) 
    {
        mem = arr[i];
        arr[i]=arr[(num-1)-i];
        arr[(num-1)-i] = mem;
    }
    }

    else {
    for (i=0;i<num/2;i++) 
    {
        mem = arr[i];
        arr[i]=arr[(num-1)-i];
        arr[(num-1)-i] = mem;
    }
    }

    for(i = 0; i < num; i++)
        printf("%d ", *(arr + i));
    return 0;
}



