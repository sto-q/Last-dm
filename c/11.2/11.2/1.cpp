#include<stdio.h>
int main( ) {
	int n;
	int sum[1000] = { 0 };
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf_s("%d", &sum[i]);
	}
	int max = 1;
	int ha = 1;
	for (int m = 0; m < n - 1; m++) {
		if (sum[m] < sum[m + 1]) {
			ha++;
			if (ha > max) {
				max = ha;
			}
		}else{
				ha = 1;
			 }
		}

	printf("%d", max);
	return 0;
}