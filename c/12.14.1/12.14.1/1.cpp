#include<stdio.h>
int X(int* sum, int e, int stx) {
	int* i = sum;
	for (int* j = sum; j < sum+stx; j++) {
		if (*j != e) {
			*i = *j;
			i++;
		}
	}
	return i - sum;
}
int main() {
	int sum[] = { 1,2,3,4,5,6,7,8,9 };
	int n;
	int stx = sizeof(sum) / sizeof(sum[0]);
	scanf_s("%d", &n);
	printf("%d",X(sum, n, stx));
	return 0;
}