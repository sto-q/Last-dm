#include<stdio.h>
#define MAX 10000
void H(int* sum,int a,int b) {
	for (int i = a; i <= b; i++) {
		sum[i] = 1;
	}
}
int main() {
	int m, l;
	scanf_s("%d %d", &l, &m);
	int sum[MAX] = { 0 };
	int count = 0;
	int a, b;
	for (int i = 0; i < m; i++) {
		scanf_s("%d %d", &a, &b);
		H(sum, a, b);
	}
	for (int i = 0; i <= l; i++) {
		if (sum[i] == 1) {
			count++;
		}
	}
	printf("%d", l+1 - count);
	return 0;
}