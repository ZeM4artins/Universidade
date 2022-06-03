#include <stdio.h>
#include <stdlib.h>


// void bubble (int v[], int N) {
//     for (int i=0;i<N-1;i++)
//     if (v[i]>v[i+1]) swap (v,i,i+1);
// }


// void bubbleSort (int v[],int N) {
//     int i;
//     for (i=0;i<N;i++) {bubble (v,N);  printf ("%d",v[i]);}
// }

// void ordena (int v[], int N) {
//     int m,i,j;

//     for (j=0;j<N;j++) {
//         //descobrir o menor elemento desde j até N
//         m=j;
//         for (i=j+1;i<N;i++) {
//             if (v[i] < v[m]) m=i;
//         swap (v,j,i);
//         printf ("%d",v[i]);}
        
//     }
// }

void swap(int* xp, int* yp)
{
    int temp = *xp;
    *xp = *yp;
    *yp = temp;
}
 
// Function to perform Selection Sort
int selectionSort(int arr[], int n)
{
    int i, j, min_idx,vezes;
 
    // One by one move boundary of unsorted subarray
    for (i = 0; i < n - 1; i++) {
 
        // Find the minimum element in unsorted array
        min_idx = i;
        for (j = i + 1; j < n; j++)
            if (arr[j] < arr[min_idx])
                min_idx = j;
 
        // Swap the found minimum element
        // with the first element
        swap(&arr[min_idx], &arr[i]);
        vezes++;
    }
    return vezes;
}


int sumhtpo (int n){
    int r = 0;
    while (n != 1) {
        r += n;
        if (n%2 == 0) n = n/2;
        else n = 1+(3*n);
        printf("%d \n", n);
    }
    return r;
}

int main(){
    int arr[97];

    printf("%d\n",selectionSort(arr,97));

    return 0;
}

