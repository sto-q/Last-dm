#include<stdio.h>
#include<stdlib.h>
#define MAX_L 
typedef struct Q {
	int *data;
	int wei=0;
	int to = 0;
}Last;
Last* Cshi() {
	Last* P = (Last*)malloc(sizeof(Last));
	P->data = (int*)malloc(sizeof(int) * MAX_L);
	return P;
}
void Rd(Last* p, int e) {
	p->data[p->wei] = e;
	p->wei++;
}
int main() {
	Last* p = Cshi();
	return 0;
}