#include<stdio.h>
#include<math.h>
int main() {
	int sum[100];
	int m, n;
	int count = 0;
	scanf_s("%d %d", &m, &n);
	for (m; m < n; m++) {
		int a = m / 100;
		int b = m / 10 % 10;
		int c = m % 10 % 10;
		if (pow(a, 3) + pow(b, 3) + pow(c, 3) == m) {
			sum[count++] = m;
		}
	}
	for (int i = 0; i < count; i++) {
		printf("%d\n", sum[i]);
	}
	return 0;
}