#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct k{
	struct k* next;
	int hao;
	char name[100];
	int data[3];
}Last;
Last* chushi() {
	Last* p = (Last*)malloc(sizeof(Last));
	p->next = NULL;
	return p;
}
Last* cha(Last* p,int n,char*Name,int e1,int e2,int e3) {
	Last* h = (Last*)malloc(sizeof(Last));
	Last* tail=p;
	while (tail->next != NULL) {
		tail = tail->next;
	}
	tail->next = h;
	h->data[0] = e1;
	h->data[1] = e2;
	h->data[2] = e3;
	h->hao = n;
	strncpy_s(h->name, Name, sizeof(h->name) - 1);
	h->next = NULL;
	return h;
}
void bianli(Last* p) {
	printf("排名:");
	while (p->next != NULL) {
		p = p->next;
		printf("名字:%s\t", p->name);
	}
}
void paixu(Last* p,int n) {
	for (int i = 1; i < n-1; i++) {
		Last* cou = p->next;
		Last* prev = p;
		for (int k = 0; k  < n-i-1; k++) {
			int cot1 = cou->data[0] + cou->data[1] + cou->data[2]/3;
			int cot2 = cou->next->data[0] + cou->next->data[1] + cou->next->data[2] / 3;
			if (cot1<cot2) {
				Last* E = cou->next;
				cou->next = E->next;
				E->next = cou;
				prev->next = E;
				cou = E;
			}
			prev = cou;
			cou = cou->next;
		}
	}
}
int main() {
	int n;
	Last*M=chushi();
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		int n, e1,e2,e3;
		char k[100];
		printf("学号:");
		scanf_s("%d",&n);
		printf("名字:");
		scanf_s("%s", k, (unsigned int)sizeof(k));
		printf("成绩:");
		scanf_s("%d %d %d", &e1,&e2,&e3);
		cha(M, n, k, e1,e2,e3);
		printf("\n");
	}
	paixu(M, n);
	bianli(M);
	return 0;
}