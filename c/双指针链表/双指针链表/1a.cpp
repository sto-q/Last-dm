#include<stdio.h>
#include<stdlib.h>
#include<math.h>
typedef struct last {
	int data;
	struct last* next;
}Last;
//初始化
Last* qwe() {
	Last* P= (Last*)malloc(sizeof(Last));
	P->next = NULL;
	return P;
}
//遍历
void poi(Last* p) {
	Last* P = p->next;
	while (P != NULL) {
		printf("%d\t", P->data);
		P= P->next;
	}
	printf("\n");
}
//输入
void asd(Last* p, int e) {
	Last* m = (Last*)malloc(sizeof(Last));
	m->data = e;
	m->next = NULL;
	Last* M = p;
	while (M->next != NULL) {
		M = M->next;
	}
	M->next = m;
}
//找到倒数的值
void zxc(Last* p) {
	Last* M=p->next;
	Last* N = p->next;
	int n;
	printf("查找倒数第几个数:");
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		M = M->next;
	}
	while (M != NULL) {
		M = M->next;
		N = N->next;
	}
	printf("%d\n", N->data);
}
//删除相同值
void lkj(Last* p) {
	Last* J = p->next;
	int Max = 0;
	while (J != NULL) {
		int max = abs(J->data);
		if (J->data > Max) {
			Max = J->data;
		}
		J = J->next;
	}
	printf("删除相同值:\n");
	Last* U = p;
	int* Q;
	Q = (int*)malloc(sizeof(int)*(Max+1));
	int Da;
	for (int i = 0; i < Max+1; i++) {
		*(Q + i) = 0;
	}
	while (U->next != NULL) {
		Da = abs(U->next->data);
		if (*(Q + Da) == 0) {
			*(Q + Da) = 1;
			U = U->next;
		}
		else {
			Last* K= U->next;
			U->next = K->next;
			free(K);
		}
	}
	free(Q);
}
//反转链表
void mnb(Last* Q) {
	Last *a1 = NULL;
	Last* a2 = Q->next;
	Last* a3;
	while (a2 != NULL) {
		a3 = a2->next;
		a2->next = a1;
		a1 = a2;
		a2 = a3;
	}
    Q->next = a1;
}
//删除中间节点
int dfg(Last* p) {
	printf("删除中间值:\n");
	Last* A = p;
	Last* B = p->next;
	while (B != NULL&&B->next != NULL) {
		A = A->next;
		B = B->next->next;
	}
	Last* K = A->next;
	A->next = K->next;
	free(K);
	return 0;
}
//撇断倒转插入
Last* ewr(Last* p) {
	printf("倒转插入:");
	Last* A = p;
	Last* B = p->next;
	while (B != NULL && B->next != NULL) {
		A = A->next;
		B = B->next->next;
	}
	Last* G = A->next;
	A->next=NULL;
	Last* toG = qwe();
	toG->next =G;
	mnb(toG);
	G = toG->next;
	Last* tail = p;
	Last* F = p->next;
	while (F!= NULL && G != NULL) {
		Last* E = F->next;
		Last* D = G->next;
		tail->next = F;
		F->next = G;
		G->next = E;
		tail = G;
		F = E;
		G = D;
	}
	if (F != NULL) {
		tail->next = F;
	}
	if (G != NULL) {
		tail->next = G;
	}
	free(toG);
	return p;
}
int main() {
	Last *QQ=qwe();
	int n,m;
	scanf_s("%d", &n);
	for (int i = 0; i< n; i++) {
		scanf_s("%d", &m);
		asd(QQ, m);
	}
	poi(QQ);
	zxc(QQ);
	lkj(QQ);
	poi(QQ);
	printf("链表倒转:\n");
	mnb(QQ);
	poi(QQ);
	dfg(QQ);
	poi(QQ);
	ewr(QQ);
	poi(QQ);
	return 0;
}