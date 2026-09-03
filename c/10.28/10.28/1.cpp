#include<stdio.h>
int main() {
	char n[100] = {0};
	gets_s(n);
	for (int i = 0; i < sizeof(*n)/sizeof(n[0]); i++) {
		if (n[i] <= 'z' && n[i] >= 'a') {
			n[i] -= 32;
		}
	}
	printf("%s", n);
	return 0;
}