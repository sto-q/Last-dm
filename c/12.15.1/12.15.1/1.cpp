#include<stdio.h>
#include<stdlib.h>
typedef struct k {
	struct k* next;
	struct k* shan;
	int data;
}Last;
Last* ctear() {
	Last* p = (Last*)malloc(sizeof(Last));
	p->next = NULL;
	p->shan = NULL;
	p->data = 0;
	return p;
}
void Rd(Last* p, int e) {
	Last* H = p;
	Last* B = (Last*)malloc(sizeof(Last));	
	B->data = e;
	while (H->next != NULL) {
		H = H->next;
	}
	H->next = B;
	B->next = NULL;
	B->shan = H;
}
int San(Last* p, int e) {
	Last* k = p;
	while (k->next != NULL) {
	k=k->next;
	}
	for (int i = 0; i < e; i++) {
		k = k->shan;
	}
	Last* M=k->next;
	k->next = M->next;
	if (M->next != NULL) {
		M->next->shan = k;
	}
	free(M);
	return 1;
}
void to(Last* P) {
	Last* k = P->next;
	while (k != NULL) {
		printf("%d\t", k->data);
		k = k->next;
	}
}

int main() {
	Last* p = ctear();
	Rd(p, 1);
	Rd(p, 2);
	Rd(p, 3);
	Rd(p, 4);
	Rd(p, 5);
	Rd(p, 6);
	San(p, 1);
	to(p);
	return 0;
}