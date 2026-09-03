#include<stdio.h>
bool isp(int a) {
	if (a < 2) { return false; }
	if (a == 2) { return true; }
	if (a % 2 == 0) { return false; }
	for (int i = 3; i * i <= a; i += 2) {
		if (a % i == 0) { return false; }
	}
}
int main() {
	int a, b;
	scanf_s("%d %d", &a, &b);
	for (a; a < b; a++) {
		if (isp(a)) {
			printf("%d  ", a);
		}
	}
	return 0;
}