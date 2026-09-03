#include<stdio.h>
int main() {
	int nian, yu;
	int month[] = { 31,28,31,30,31,30,31,31,30,31,30,31 };
	scanf_s("%d %d", &nian, &yu);
	if (nian % 100 != 0 && nian % 4 == 0 || nian % 400 == 0) {
		month[1] = 29;
	}
	printf("%d", month[yu - 1]);
	return 0;
}