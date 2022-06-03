#include <stdio.h>
#include <assert.h>

// int hash (char s[]) {
//   int i,r = 0;
//   for (i=1;*s;i++) {
//   r += *s*i; s++;
//   }
//   return r;
// }

// int main (){
//     int n = hash ("programacao logica");
    
//     printf("%d",n);
//     return n; 

// }

int hash (char s[]) {
  int r = 0;
  while (*s) {r += *s; s++;}
  return r;
}

int next(char s[], int n) {
 while (n > 0) {
   n--;
   if (s[n] < 'z') {
     s[n]++;
     return 1;
   } else {
     s[n] = 'a';
   }
 }
 return 0;
}

int main () {
 char s[10];
 int n,i;
 for (n=0;n<10;n++) {
   for (i=0;i<n;i++) s[i] = 'a';
   s[n] = '\0';
   if (hash(s) ==530) {
   do {
     printf("%s\n",s);
    } while(next(s,n));
   }
 }
 return 0;
}