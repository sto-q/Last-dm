#include<stdio.h>
void X(int* sum, int size, int e) {
    for (int i = 0; i < size - 1; i++) {
        for (int j = i + 1; j < size; j++) {
            if (sum[i] + sum[j] == e) {
                printf("%d %d\n", i, j);
            }
        }
    }
}
int main() {
    int sum[] = { 1,2,3,4,5,6,7,8,9,0 };
    int lengh = sizeof(sum) / sizeof(sum[0]);
    X(sum, lengh, 3);
    return 0;
}
