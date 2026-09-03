#include<stdio.h>
int main() {
	int n=3;
	char S;
	scanf_s("%c", &S);
	for (int a = 1; a <= n; a++) {
		for (int b = n - a; b > 0; b--) {
			printf(" ");
		}
		for (int c = 1; c <= 2 * a - 1; c++) {
			putchar(S);
		}
		printf("\n");
	}
	return 0;
}