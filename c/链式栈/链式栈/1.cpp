#include<stdio.h>
#include<stdlib.h>
typedef struct L {
	int data;
	struct L* next;
}Last;
Last* poi() {
	Last* P = (Last*)malloc(sizeof(Last));
	P->next = NULL;
	return P;
}
void mnb(Last* p, int e) {
	Last*k= (Last*)malloc(sizeof(Last));
	k->data = e;
	k->next = p->next;
	p->next = k;
}
void qwe(Last* p) {
	Last* P = p->next;
	while (P != NULL) {
		printf("%d\t", P->data);
		P = P->next;
	}
	printf("\n");
}
void lkj(Last* p) {
	if (p->next == NULL) {
		printf("kong\n");
	}
	Last* P=p->next;
	p->next = P->next;
	free(P);
}
void po(Last* p) {
	if (p->next == NULL) {
		printf("kong");
	}
	printf("Õ»¶¥Îª:%d\n", p->next->data);
}
int main() {
	Last* last=poi();
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		int e;
		scanf_s("%d", &e);
		mnb(last, e);
	}
	qwe(last);
	lkj(last);
	qwe(last);
	po(last);
	return 0;
}