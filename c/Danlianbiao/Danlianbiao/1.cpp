#include<stdio.h>
#include<stdlib.h>
typedef struct last{
	int data;
	struct last * next;
}Last;
//初始化
Last* lastnow() {
	Last* now = (Last*)malloc(sizeof(Last));
	now->data = 0;
	now->next = NULL;
	return now;
}
//尾插法
void poi(Last* L, int a) {
	Last*M= (Last*)malloc(sizeof(Last));
	M->data = a;
	M->next = NULL;
	Last* temp = L;
	while (temp->next != NULL) {
		temp = temp->next;
	}
	temp->next = M;
}
//遍历
void qwe(Last* L) {
	Last* p = L->next;
	while (p != NULL) {
		printf("%d\t", p->data);
		p = p->next;
	}
	printf("\n");
}
//插入
void mnb(Last* p, int pot,int e) {
	Last* q = (Last*)malloc(sizeof(Last));
	q->data = e;
	Last* N=p;
	for (int i = 0; i < pot-1; i++) {
		N = N->next;
	}
	q->next=N->next;
	N->next=q;
}
//删除
void zxc(Last* L, int k) {
	Last* S = L;
	for (int i = 0; i < k-1; i++) {
		S = S->next;
	}
	Last* p = S->next;
	S->next = p->next;
	free(p);
}
//链表长度
void kjh(Last* L) {
	int lon = 0;
	Last* U=L;
	while (U->next != NULL) {
		lon++;
		U = U->next;
	}
	printf("长度为:%d\n", lon);
}
//释放链表
void cvb(Last* w) {
	Last* p = w->next;
	Last* q;
	while (p!= NULL) {
		q = p->next;
		free(p);
		p=q ;
	}
	w->next = NULL;
}
int main() {
	 last *Leat= lastnow();//头链表
	 int n;
	 scanf_s("%d", &n);
	 //传入数据
	 for (int i = 0; i < n; i++) {
		 int m;
		 scanf_s("%d", &m);
		 poi(Leat, m);
	 }
	 qwe(Leat);
	 int p,q;
	 printf("插入的位置和值：");
	 scanf_s("%d %d", &p,&q);
	 mnb(Leat, p, q);
	 qwe(Leat);
	 printf("删除的位置:");
	 int h;
	 scanf_s("%d", &h);
	 zxc(Leat, h);
	 qwe(Leat);
	 kjh(Leat);
	 cvb(Leat);
	return 0;
}