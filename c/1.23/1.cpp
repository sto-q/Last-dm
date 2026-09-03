#include<stdio.h>
#include<stdlib.h>
#define MAX 100
typedef struct Array {
	int* data;
	int Si;
}ArrayLast;
ArrayLast createLast() {
	ArrayLast p;
	 p.data=(int*)malloc(sizeof(int)*MAX);
	 p.Si = 0;
	 return p;
};
void add(ArrayLast*p,int e){
	p->data[p->Si++] = e;
}
void Insert(ArrayLast* p, int e, int E) {
	for (int i = p->Si-1; i >= E-1; i--) {
		p->data[i+1] = p->data[i];
	}
	p->data[E] = e;
	p->Si++;
}
int Find(ArrayLast* p,int e) {
	for (int i = 0; i < p->Si; i++) {
		if (p->data[i] == e)return i;
}
	return -1;
}
void Delet(ArrayLast* p, int e) {
	int i = Find(p, e);
	for (int k = i; k < p->Si-1; k++) {
		p->data[k] = p->data[k + 1];
	}
	p->Si--;
}
void Show(ArrayLast p) {
	for (int i = 0; i < p.Si; i++) {
		printf("%d ", p.data[i]);
	}
	printf("\n");
}
int main() {
	ArrayLast p;
	p= createLast();
	add(&p, 1);
	add(&p, 2);
	add(&p, 3);
	add(&p, 4);
	add(&p, 5);
	add(&p, 6);
	add(&p, 7);
	add(&p, 8);
	add(&p, 9);
	Show(p);
	Insert(&p, 23, 4);
	Show(p);
	Delet(&p, 3);
	Show(p);
	return 0;
}