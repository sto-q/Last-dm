#include<stdio.h>
#include<stdlib.h>
#define DataMax 100
typedef struct {
	int data[DataMax];
	int next;
	int no ;
}Last;
void poi(Last* p) {
	p->next = 0;
	p->no = 0;
}
int qwe(Last* p,int e) {
	if (p->next >= DataMax ) {
		return 0;
	}
	p->data[p->next] = e;
	p->next++;
	return 1;
}
void lkj(Last* p) {
	while (p->no != p->next) {
		printf("%d\t",p->data[p->no]);
		p->no++;
	}
	printf("\n");
}
int asd(Last* p) {
	if (p->no > 0) {
		int zo = p->no;
		for (int i = p->no; i < p->next; i++) {
			p->data[i - zo] = p->data[i];
		}
		p->no = 0;
		p->next = p->next - zo;
		return 0;
	}
	return 0;
}
int main() {
	Last last;
	poi(&last);
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		int e;
		scanf_s("%d", &e);
		qwe(&last,e);
	}
	lkj(&last);
	asd(&last);
	return 0;
}