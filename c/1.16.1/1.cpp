#include<stdio.h>
#include<string.h>
int main() {
	char name[1000];
	gets_s(name);
	int sum = strlen(name);
	for (int i = sum; i >=0; i--) {
		printf("%c",name[i]);
	}
	return 0;