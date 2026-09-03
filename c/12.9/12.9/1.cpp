#include<stdio.h>
#include<stdlib.h>
int Q(int n,int e) {
	if (n == 0) {
		return e;
	}
	return Q(n - 1, e + n);
}
int main() {
	int n;
	int e=0;
	scanf_s("%d", &n);
	int f = Q(n, e);
	printf("%d",f);
	return 0;
}