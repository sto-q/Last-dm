#include<stdio.h>
int main() {
	int n;
	int count;
	int sum[10000] = { 0 };
	scanf_s("%d %d", &n, &count);
	for (int i = 0; i < n; i++) {
		scanf_s("%d", &sum[i]);
	}
	for (int k = 0; k < count; k++) {
		int i = 0;
		scanf_s("%d", &i);
		printf("%d\n", sum[i - 1]);
	}
	return 0;
}