#include<stdio.h>
int main() {
	int A, B, C;
	int sum[3] = {0};
	for (int i = 0; i < 3; i++) {
		scanf_s("%d", &sum[i]);
	}
	for (int i = 0; i < 2; i++) {
		for(int m=0;m<2-i;m++)
		if (sum[m] > sum[m + 1]) {
			int p = sum[m];
			sum[m] = sum[m + 1];
			sum[m + 1] = p;
		}
	}
	C = sum[2];
	B = sum[1];
	A = sum[0];
	while (getchar() != '\n');
	char L[3];
	for (int j = 0; j < 3; j++) {
		scanf_s("%c", &L[j]);
	}
	for (int j = 0; j < 3; j++) {
		switch (L[j]) {
		case 'A': printf("%d ", A); break;
		case 'B': printf("%d ", B); break;
		case 'C': printf("%d ", C); break;
		}
		printf("\n");
	}
	return 0;
}