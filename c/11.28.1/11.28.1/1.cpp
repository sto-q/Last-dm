#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX_L 1000
typedef struct u {
	int *data;
	int fist;
	int wei;
}Lie;
Lie* ceate() {
	Lie* p = (Lie*)malloc(sizeof(Lie));
	p->data = (int*)malloc(sizeof(int) * MAX_L);
	p->fist = 0;
	p->wei = 0;
	return p;
}
void getLie(Lie* p,int e) {
	p->data[p->wei] = e;
	p->wei++;
}
//
void daozhuan(Lie* p) {
	Lie* P = p;
	if (P->fist == P->wei) {
		printf("wu\n");
		return;
	}
	int lengh = P->wei - P->fist;
	for (int i = 0; i < lengh / 2; i++) {		
		int L = P->fist  + i;
		int R = P->wei - 1-i;
		int e=P->data[L];
		P->data[L] = P->data[R];
		P->data[R] = e;
	}
}
void Last(Lie* p,int e) {
	int found = -1;
	for (int i = p->fist; i < p->wei; i++) {
		if (p->data[i] == e) {
			found = i;
			break;
		}
	}
	int g = p->data[found];
	for (int i = found; i < p->wei - 1; i++) {
		p->data[i] = p->data[i + 1];
	}
	p->data[p->wei - 1] = g;
}
void Flrst(Lie* p, int e) {
	int count = -1;
	for (int i = p->fist; i < p->wei; i++) {
		if (p->data[i] == e) {
			count = i;
			break;
		}
	}
	int f = count;
	int j = p->data[count];
	for (int i = f; i >p->fist; i--) {
		p->data[i] = p->data[i - 1];
	}
	p->data[p->fist] = j;
}
void bian(Lie* p) {
	for (int i = p->fist; i < p->wei; i++) {
		printf("%d ", p->data[i]);
	}
	printf("\n");
}
int main() {
	Lie* p=ceate();
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		int e;
		scanf_s("%d", &e);
		getLie(p, e);
	}
	while (getchar() != '\n');
	int X;
	scanf_s("%d", &X);
	for (int i = 0; i < X; i++) {
		char asd[10];
		scanf_s("%s", asd, sizeof(asd));
		if (strcmp(asd, "FIRST") == 0) {
			printf(":");
			int q;
			scanf_s("%d", &q);
			Flrst(p, q);
			printf("\n");
		}
		else if (strcmp(asd, "LAST") == 0) {
			printf(":");
			int r;
			scanf_s("%d", &r);
			Last(p, r);
			printf("\n");
		}
	}
		bian(p);
		printf("\n");
		daozhuan(p);
		printf("µ¹×ª£º");
		bian(p);
	return 0;
}