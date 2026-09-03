#include<stdio.h>
#include<stdlib.h>
typedef struct lmq {
	int data;
	struct lmq* next, * qiang;
}Last;
Last* qwe() {
	Last* k = (Last*)malloc(sizeof(Last));
	k->next = NULL;
	k->qiang = NULL;
	return k;
}
void poi(Last* p, int e) {
	Last* K= (Last*)malloc(sizeof(Last));
	while (p->next != NULL) {
		p = p->next;
	}
	K->data = e;
	K->next = NULL;
	K->qiang = p;
	p->next = K;
}
void mnb(Last* p) {
	while (p->next != NULL) {
		printf("%d\t", p->next->data);
		p = p->next;
	}
	printf("\n");
}
void zxc(Last* p) {
	int n, e;
	printf("添加位置与值:");
	scanf_s("%d %d", &n, &e);
	Last* K = (Last*)malloc(sizeof(Last));
	K->data = e;
	for (int i = 0; i < n-1; i++) {
		p = p->next;
	}
	K->qiang = p;
	K->next = p->next;
	p->next = K;
}
void lkj(Last* p) {
	int pot;
	printf("删除的位置:\n");
	scanf_s("%d", &pot);
	Last* K = (Last*)malloc(sizeof(Last));
	for (int i = 0; i < pot - 1; i++) {
		p = p->next;
	}
	K = p->next;
	p->next = K->next;
	K->next->qiang = p;
	free(K);
}
void asd(Last* p) {
	Last* T = p->next;
	Last* t;
	while (T != NULL) {
		t = T->next;
		free(T);
		T = t;
	}
}
int main() {
	Last* last;
	last=qwe();
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		int e;
		scanf_s("%d", &e);
		poi(last, e);
	}
	mnb(last);
	zxc(last);
	mnb(last);
	lkj(last);
	mnb(last);
	asd(last);
	return 0;
}