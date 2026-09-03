#include<stdio.h>
#include<stdbool.h>
bool isPrime(int num) {
	if (num % 2 == 0) return false;
	for (int i = 3; i * i <= num; i += 2) {
		if (num % i == 0) return false;
	}
	return true;
}
int main() {
	int a,b;
	int sum[100000] = { 5,7,11 };
	int Sum[100000] = { 0 };
	int count = 3;
	int sut = 0;
	int m = 0;
	scanf_s("%d %d", &a,&b);
	for (int d1 = 1; d1 <= 9; d1 += 2) {
		for (int d2 = 0; d2 <= 9; d2++) {
			sum[count++] = d1 * 100 + d2 * 10 + d1;
		}
	}
	for (int d1 = 1; d1 <= 9; d1 += 2) {
		for (int d2 = 0; d2 <= 9; d2++) {
			for (int d3 = 0; d3 <= 9; d3++) {
				sum[count++]=d1*10000+d2*1000+d3*100+d2*10+d1;
			}
		}
	}
	for (int j = 0; j < count; j++) {
		if (sum[j] >= a && sum[j] <= b && isPrime(sum[j])) {
			printf("%d\n", sum[j]);
		}
	}
	return 0;
}