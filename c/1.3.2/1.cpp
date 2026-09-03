#include<stdio.h>
#include<string.h>
int main() {
	char srt[100];
	gets_s(srt);
	int len = strlen(srt);
	if (len > 0 && srt[len - 1] == '\n') {
		srt[len- 1] = '\0';
		len--;
	}
	for (int i = len; i >= 0; i--) {
		printf("%c", srt[i]);
	}
	return 0;
}