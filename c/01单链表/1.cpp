#include<stdio.h>
#include<stdlib.h>
typedef struct k {
	int data;
	struct k* next;
}last;
last*eary() {
	last* k = (last*)malloc(sizeof(last));
	k->data = 0;
	k->next = NULL;
	return k;
}
void run(last* p, int e) {
	last* k = (last*)malloc(sizeof(last));
	k->data = e;
	k->next = NULL;
	p->next = k;
}
void Show(last* p) {
	while (p->next != NULL) {
		printf("%d", p->data);
		p = p->next;
	}
}
int  main() {
	last* p;
	p = eary();
	run(p, 1);
	run(p,2);
	run(p, 3);
	Show(p);
	return 0;
}