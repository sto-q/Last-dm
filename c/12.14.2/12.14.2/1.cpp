#include<stdio.h>
int F(int e) {
	if (e == 1) return 1;
	if (e == 0)return 0;
	return F(e - 1) + F(e - 2);
}
int main() {
	int n;
	scanf_s("%d", &n);
	int X = F(n);
	printf("%d", X);
	return 0;
}