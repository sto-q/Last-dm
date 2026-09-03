#include<stdio.h>
#include<stdlib.h>
#define count 100
typedef struct kk {
	int data[count];
	int top;
}Last;
Last*qwe () {
	Last* k = (Last*)malloc(sizeof(Last));
	k->top = 0;
	return k;
}
void mnb(Last* p, int e) {
	if (p->top == count-1) {
		printf("manle\n");
	}
	p->data[p->top] = e;
	p->top++;
}
void lkj(Last* p) {
	if (p->top == 0) {
		printf("wule\n");
	}
	printf("%d\n", p->data[p->top-1]);
	p->top--;
}
void poi(Last* p) {
	if (p->top == 0) {
		printf("wule\n");
	}
	printf("%d\n", p->data[p->top-1]);
}
int main() {
	Last* Q=qwe();
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		int e;
		scanf_s("%d", &e);
		mnb(Q, e);
	}
	lkj(Q);
	poi(Q);
	return 0;
}