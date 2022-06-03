#include <stdio.h>
#include <assert.h>

int sumhtpo (int n){
  int r = 0;
  int c = 0;
  while (n != 1) {
    r += n;
    if (n%2 == 0) n = n/2;
    else n = 1+(3*n);
    if (c<n) c=n;
  }
  return c;
}

int main () {
    int n = 31;
    int res;

    res = sumhtpo (31);
    printf ("%d\n", res);
return 0;
}