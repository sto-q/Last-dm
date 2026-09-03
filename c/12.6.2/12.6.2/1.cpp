#include<stdio.h>
#include<string.h>
int main() {
	char Co[1000];
	int sum[1000];
	int count = 0;
	int poi = 0;
	gets_s(Co);
	for (char i = 0; i <= sizeof(Co); i++) {
		if (Co[i]!= ' ') {
			poi++;
		}else if (Co[i] == ' ') {
			sum[count++] = poi;
			poi = 0;
		}if (Co[i] == '\0') {
			sum[count++] = poi - 1;
		}
	}
	for (int i = 0; i < count; i++) {
		printf("%d ", sum[i]);
	}
	return 0;
}  