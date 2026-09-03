#include<stdio.h>
int main() {
	int m, t, s;
	scanf_s("%d %d %d", &m, &t, &s);
	if (t == 0) {
		printf("%d", 0);
	}
	else {
		int k = m-s / t;
		if (k < 0) {
			k = 0;
		}
		printf("%d", k);
	}
	return 0;
}