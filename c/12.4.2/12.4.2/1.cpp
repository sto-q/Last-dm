#include<stdio.h>
int main() {
	int* n;
	int* m;
	scanf_s("%d %d", &n, &m);
	int *p = n;
	n = m;
	m = p;
	printf("%d %d", n, m);
	return 0;
}