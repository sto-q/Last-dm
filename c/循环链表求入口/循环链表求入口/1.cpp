#include<stdio.h>
#include<stdlib.h>
typedef struct k {
	int data;
	struct k* next;
}Last;
Last* poi() {
	Last* p = (Last*)malloc(sizeof(Last));
	p->next = NULL;
	return p;
}
Last* mnb(Last* p, int a) {
	Last* P = (Last*)malloc(sizeof(Last));
	P->data = a;
	P->next = NULL;
	p->next = P;
	return P;
}
Last* qwe(Last* p) {
	Last* a1 = p;
	Last* a2 = p;
	while (a2 != NULL && a2->next != NULL) {
		a1 = a1->next;
		a2 = a2->next->next;
		if (a1 == a2) {
			printf("有循环\n");
			a1 = p;
			while (a1 != a2) {
				a1 = a1->next;
				a2 = a2->next;
			}
			return a1;
		}
	}
	return NULL;
}
int main() {
	Last* head = poi();
	Last* QQ=head;
    QQ=mnb(QQ, 1);
	QQ=mnb(QQ, 2);
	QQ=mnb(QQ, 3);
	QQ=mnb(QQ, 4);
	Last* Q = QQ;
	QQ=mnb(QQ, 5);
	QQ=mnb(QQ, 6);
	QQ=mnb(QQ, 7);
	QQ=mnb(QQ, 8);
	QQ=mnb(QQ, 9);
	QQ->next = Q;
	Last* T = qwe(head->next);
	printf("链表的入口值为:%d",T->data);
	return 0;
}