#include<stdio.h>
#include<stdlib.h>
#define MAX 6
typedef struct k {
	int* sum;
	int to;
	int wei;
}Last;
Last* chushi() {
	Last* p = (Last*)malloc(sizeof(Last));
	p->sum = (int*)malloc(sizeof(int) * MAX);
	p->to = 0;
	p->wei = 0;
	return p;
}
void Rd(Last*p,int e) {
	if ((p->wei + 1) % MAX == p->to) {
		printf("Man\n");
		return ;
	}
	p->sum[p->wei] = e;
	p->wei=(p->wei+1)%MAX;
}
void Cd(Last* p) {
	if (p->to == p->wei) {
		printf("wu\n");
	}
	printf("%d " ,p->sum[p->to]);
	p->to = (p->to + 1) % MAX;
	printf("\n");
}
void To(Last* p) {
	printf("%d", p->sum[p->to]);
}
int main() {
	Last* p = chushi();
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		int e;
		scanf_s("%d", &e);
		Rd(p, e);
	}
	int N;
	scanf_s("%d", &N);
	for (int i = 0; i < N; i++) {
		Cd(p);
	}
	To(p);
	return 0;
}