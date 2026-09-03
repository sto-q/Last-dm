#include<stdio.h>
#include<stdlib.h>
#define MAX 5
typedef struct k {
	int data[MAX];
	int to;
	int wei;
}Last;
void Rd(Last* p,int e) {
	if (p->to == (p->wei+1)%MAX) {
		return;
	}
	p->data[p->wei] = e;
	p->wei = ((p->wei) + 1) % MAX;
}
void BL(Last* P) {
	Last* p = P;
	if (p->to == p->wei) {
		return;
	}
	while (p->to != p->wei) {
		printf("%d\t", p->data[p->to]);
		p->to = (p->to + 1) % MAX;
	}
}
void F(Last* p) {
	Last* L= (Last*)malloc(sizeof(Last));
	L->to = 0;
	L->wei = 4;
	for (int i = 0; i <4; i++) {
		L->data[i] = p->data[(3-i)%MAX];
	}
	BL(L);
}
int main() {
	Last* p=(Last*)malloc(sizeof(Last));
	p->to = 0;
	p->wei = 0;
	Rd(p, 1);
	Rd(p, 2);
	Rd(p, 3);
	Rd(p, 4);
	Rd(p, 5);
	Rd(p, 6);
	BL(p);
	printf("\n");
	F(p);
	free(p);
}