#include<stdio.h>
#include<stdlib.h>
#include<string.h>
typedef struct k {
	struct k*next;
	int id;
	char name[20];
	int math;
}Last;
Last* chu() {
	Last* p = (Last*)malloc(sizeof(Last));
	p->next = NULL;
	return p;
}
void as(Last* p, int id, char* name, int math) {
	Last* k = (Last*)malloc(sizeof(Last));
	k->id = id;
	strcpy_s(k->name,20,name);
	k->math = math;
	k->next = NULL;
	Last* temp = p;
	while (temp->next != NULL) {
		temp = temp->next;
	}
	temp->next = k; 
}
void aa(Last* P) {
	Last* p = P->next;
	while (p != NULL) {
		printf("%d %s %d", p->id, p->name, p->math);
		p = p->next;
	}
}
int main() {
	Last* p = chu();
	int n;
	scanf_s("%d", &n);
	int id;
	char name[20];
	int math;
	for (int i = 0; i < n; i++) {
		scanf_s("%d %s %d", &id, name,& math, sizeof(name));
		as(p, id, name, math);
	}
	aa(p);
	return 0;
}