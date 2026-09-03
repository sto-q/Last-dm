#include<stdio.h>
#include<math.h>
int main() {
	int n;
	scanf_s("%d", &n);
	double a = sqrt(5);
	double A = (1 + a) / 2;
	double B = (1 - a) / 2;
	double F = (pow(A, n) - pow(B, n)) / a;
	printf("%.2f", F);
	return 0;
}