#include<stdio.h>
int ip(int e) {
	if ((e % 4 == 0 && e % 100 != 0) || e % 400 == 0) {
		return 1;
	}
	else {
		return 0;
	}
}
int main() {
	int n;
	scanf_s("%d", &n);
	if (ip(n))printf("yes");
	else printf("no");
	return 0;
}