#include<stdio.h>
#include<stdlib.h>
typedef struct _lost{
	int name;
	int* next;
}Lo;
typedef struct _list {
	Lo* head;
	Lo* tail;
}List;
int main() {
	int N;
	scanf_s("%d", &N);
	List one;
	one.head = NULL;
	for (int i = 2; i < N; i++) {
		int k, p;
		scanf_s("%d %d", &k, &p);
	}
	return 0;
}