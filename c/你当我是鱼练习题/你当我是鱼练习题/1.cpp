#include<stdio.h>
int main() {
	int i;
	int sum[100];
	int j = 0;
	scanf_s("%d", &i);
	int l;
	for (l = 0; l < i; l++) {
		scanf_s("%d", sum[l]);
	}
	return 0;
}