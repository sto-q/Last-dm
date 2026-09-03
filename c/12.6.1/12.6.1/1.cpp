#include<stdio.h>
int main() {
	int n, m;
	scanf_s("%d %d", &n, &m);
	int sum[1000] = { 1,2,3,4,5,6,7,8,9 };
	int count = 9;
	for (int i = 1; i <= 9; i++) {
		sum[count++] = i * 10 + i;
	}
	for (int i = 1; i <= 9; i++) {
		for (int j = 1; j <= 9; j++) {
			sum[count++] = i * 100 + j * 10 + i;
		}
	}
	for (int i = 0; i < count; i++) {
		if (sum[i] >=n && sum[i] <= m) {
			printf("%d ", sum[i]);
		}
	}
	return 0;
}