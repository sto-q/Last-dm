#include<stdio.h>
bool isp(int a);
int main() {
	char nb[100];
	char oo[100] = {1};
	gets_s(nb);
	int count=1;
	for (int i = 0; i < sizeof(nb) / sizeof(nb[0]); i++) {
		for (int j = 1; j < sizeof(nb) / sizeof(nb[0]); j++) {
			if (nb[i] == nb[j]) {
				oo[i] += count;
			}
		}
	}
	int max, min;
		max = oo[0];
		min = oo[0];
		for (int m = 0; sizeof(oo) / sizeof(oo[0]); m++) {
			if (oo[m] < min) {
				min = oo[m];
			}if (oo[m] > max) {
				max = oo[m];
			}
	}
		if (isp(max - min)) {
			printf("Lucky wor\n %d",max-min);

		}
		else {
			printf("No Answer\n 0");
		}

	return 0;
}
bool isp(int a) {
	if (a % 2 == 0) return  false;
	if (a < 2)return true;
	for (int i = 3; i * i <= a; i += 2) {
		if (a % i == 0) return false;
	}
	return true;
}