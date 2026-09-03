#include<stdio.h>
long long qwe(int n) {
	if (n == 1) {
		 return 1;
	}
	return qwe(n - 1) * n;
}
int main() {
	int n;
	scanf_s("%d", &n);
	printf("%lld",  qwe(n));
	return 0;
}