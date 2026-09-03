#include<stdio.h>
bool nian(int a) {
	if (a % 4 == 0 &&a%100!=0||a%400==0) {
			return true;
		}
	return false;
}
int main() {
	int m = 0;
	int x,y;
	int sum[100] = { 0 };
	scanf_s("%d %d", &x,&y);
	for (x; x <= y; x++) {
		if (nian(x)) {
			sum[m++] = x;
		}
	}
	printf("%d\n", m);
	for (int i = 0; i < m; i++)
		printf("%d\t",sum[i]);
	return 0;
}