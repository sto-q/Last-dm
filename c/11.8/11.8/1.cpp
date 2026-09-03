#include<stdio.h>
int main() {
	int n;
	scanf_s("%d", &n);
	for (int a = 1; a <= n; a++) {
		for (int b = n - a; b > 0; b--) {
			printf(" ");
		}
		for (int c = 1; c <= 2 * a - 1; c++) {
			printf("*");
		}
		printf("\n");
	}for (int A = n - 1; A >= 1; A--) {
		for (int B = n-A; B >0; B--) {
			printf(" ");
		}
		for (int C = 1; C <= A * 2 - 1; C++) {
			printf("*");
		}
		printf("\n");
	}
	return 0;
}