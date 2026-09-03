#include<stdio.h>
#include<stdlib.h>
#define MAX 5
typedef struct k {
	int data[MAX];
	int next;
	int we;
}Last;
void poi(Last* p) {
	p->next = 0;
	p->we = 0;
}
int qwe(Last* p, int e) {
	if ((p->we-p->next+MAX)%MAX==MAX-1) {
		printf("manle\n");
		return 0;
	}
	p->data[p->we]=e;
	p->we = (p->we + 1) % MAX;
	return 1;
}
void lkj(Last* p) {
	int i = p->next;
	while (p->we !=i) {
		printf("%d\n", p->data[i]);
		i = (i + 1) % MAX;
	}
	printf("\n");
}
int asd(Last* p) {
	if (p->next == p->we) {
		printf("ko");
		return 0;
	}
	printf("³ö¶Ó:%d\n", p->data[p->next]);
	p->next = (p->next + 1) % MAX;
	return 0;
}
int main() {
	Last last;
	poi(&last);
	for (int i = 0; i < 7; i++) {
		int e;
		scanf_s("%d", &e);
		qwe(&last, e);
	}
	asd(&last);
	lkj(&last);
	return 0;
}