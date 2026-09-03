#include<stdio.h>
int main() {
	int n;
	int sum[1000] = { 0 };
	scanf_s("%d", &n);
	int counnt = 0;
	int k = n;
	while(k!=1) {
		sum[counnt++] = k;
		if (k % 2 == 1) {
			k = k * 3 + 1;
		}
		else {
			k = k/2;
		}
	}
	sum[counnt++]=k;
	for (int i = counnt-1; i >= 0; i--) {
		printf("%d\t", sum[i]);
	}
	return 0;
}