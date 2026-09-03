#include<stdio.h>
#include<string.h>
int main() {
	int count[26] = { 0 };
	char ch;
	while (scanf_s("%c", &ch) != EOF) {
		for (char i = 65; i <= 90; i++) {
			if (ch == i) {
				count[((int)i - 65)]++;
			}
		}
	}

	for (int i = 0; i < 676; i++) {
		int max = count[0], flog = 0;
		for (int j = 0; j < 26; j++) {
			if (max <= count[j]) {
				max = count[j];
				if (max != 0) { flog = 1; }
			}
		}
		if (flog == 0) {
			printf(" A B C D E F G H I J K L M N O P Q R S T U V W X Y Z");
			break;
		}
			for (int m = 0; m < 26; m++) {
				if (count[m] == max) {
					printf("%s%c",  " ", '*');
					count[m]--;
				}
				else {	printf("%s%s", " ", " "); }
		}
		printf("\n");
	}
	return 0;
}