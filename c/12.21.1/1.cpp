#include<stdio.h>
int  main() {
	int n, m;
	scanf_s("%d %d", &n, &m);
	int sum[10000] = { 0 };
	for (int i = 0; i < n; i++) {
		scanf_s("%d", &sum[i]);
	}
	int min = 0;
	for (int j = 0; j < m ; j++) {
		min += sum[j];
	}
	int X = 0;
	for (int i = 0; i < n - m; i++) {
		for (int j = i; j < m+i; j++) {
		 X = X + sum[j];
		}
		if (X < min) {
			min = X;
		}
		X = 0;
	}
	printf("%d", min);
	return 0;
}