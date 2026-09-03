#include<stdio.h>
void six(int e) {
	int sum[32];
	int count = 0;
	while (e > 0) {
		sum[count++] = e % 6;
		e /= 6;
	}
	for (int i = count - 1; i >=0; i--) {
		printf("%d", sum[i]);
	}
}
int main() {
	int n;
	scanf_s("%d", &n);
	six(n);
	return 0;
}