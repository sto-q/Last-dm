#include<stdio.h>
int main() {
	int n;
	int sum[100] = { 0 };
	int count = 0;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf_s("%d", &sum[i]);
	}
	for (int g = 0; g < n; g++) {
		for (int h = g + 1; h < n; h++) {
			for (int k = 0; k < n; k++) {
					if (sum[g]!=sum[h] && sum[g] + sum[h] == sum[k]) {
						count++;
				}
			}
		}
	}
	printf("%d", count);
	return 0;
}