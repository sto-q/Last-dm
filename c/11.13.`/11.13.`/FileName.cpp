#include<stdio.h>
int qwe(char* s) {
	int count = 0;
	while (*s) {
		count++;
		s++;
	}
	return count;
}
int main() {
	char sat[101];
	int (*co)(char*);
	scanf_s("%100s", sat);
	co = qwe;
	printf("%d", co(sat));
	return 0;
}