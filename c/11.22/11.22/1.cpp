#include<stdio.h>
int main() {
	int s, v;
	scanf_s("%d %d", &s, &v);
	double l = (double)s / v;
	if (l > (int)l) {
		l = l + 1;
	}
	int M = (8 * 60 - 10)-(int)l;
	if (M < 0) {
		M += 24 * 60;
	}
	int k = M / 60;
	int K = M % 60;
	printf("%02d:%02d", k, K);
	return 0;
}