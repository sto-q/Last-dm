#include<stdio.h>
int X(int sum,int e) {
	int H = 0;
	while (sum > 0) {
		if (sum % 10 == e) {
			H++;
			sum = sum / 10;
		}
		else {
			sum = sum / 10;
		}
	}
	return H;
}
int main() {
	int n ;
	int m;
	int sum[10000] = { 0 };
	scanf_s("%d %d", &n,&m);
	int count = 0;
	for (int i = 0; i < n; i++) {
		sum[i] = i+1;
		count += X(sum[i], m);
	}
	printf("%d", count);
	return 0;
}