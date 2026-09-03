#include<stdio.h>
struct sto {
	int xuehao;
	int chushi;
	int zonghe;
	int jiegou;
	int ha;
};
int main() {
	int n;
	sto stoo[100];
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf_s("%d %d %d", &stoo[i].xuehao, &stoo[i].chushi,&stoo[i].zonghe);
		stoo[i].jiegou = stoo[i].chushi + stoo[i].zonghe;
		stoo[i].ha =stoo[i]. chushi * 7 + stoo[i].zonghe * 3;
	}
	for (int k = 0; k < n; k++) {
		if (stoo[k].jiegou > 140 && stoo[k].ha > 80) {
			printf("E\n");
		}
		else {
			printf("Not\n");
		}
	}
	return 0;
}