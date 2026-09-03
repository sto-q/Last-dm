#include<stdio.h>
#define MAX 10000
int main() {
	int n;
	int sum[MAX] = { 0 };
	int Sum[MAX] = { 0 };
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf_s("%d", &sum[i]);
	}
	int count = 0;
	for (int i = 0; i < n ; i++) {
		for (int j = i+1; j < n; j++) {
			if (i == j) continue;
			for (int m = 0; m < n; m++) {
				if (m == i || m == j) continue;
				if (sum[i] + sum[j] == sum[m]) {
					Sum[m] = 1;
					break;
				}
			}
		}
	}
	for (int i = 0; i < n; i++) {
		if (Sum[i]) {
			count++;
		}
}
	printf("%d", count);
	return 0;
}