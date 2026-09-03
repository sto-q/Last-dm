#include<stdio.h>
#include<stdlib.h>
typedef struct k {
	char data;
	int lgot,rgot;
	struct k *lchild;
	struct k* rchild;
}note;
typedef note* Note;
char str[] = "ABDH##I##EJ###CF##G##";
int count = 0;
Note prev;
//初始化创建树
void gone(Note* T) {
	char ch;
	ch = str[count++];
	if (ch == '#') {
		*T = NULL;
	}
	else {
		*T = (Note)malloc(sizeof(note));
		(*T)->data = ch;
		gone(&(*T)->lchild);
		if ((*T)->lchild != NULL) {
			(*T)->lgot = 0;
		}
		gone(&(*T)->rchild);
		if ((*T)->rchild != NULL) {
			(*T)->rgot = 0;
		}
	}

}
void asd(Note T) {
	if (T != NULL) {
		asd(T->lchild);
		if (T->lchild == NULL) {
			T->lgot = 1;
			T->lchild = prev;
		}
		if (prev->rchild == NULL) {
			prev->rgot = 1;
			prev->rchild = T;
		}
	prev = T;
	asd(T->rchild);
}
}
//开始线索化
void run(Note T,Note* head) {
	*(head) = (Note)malloc(sizeof(note));
	(*head)->lchild = T;
	(*head)->lgot = 0;
	(*head)->rgot = 1;
	prev = *head;
	asd(T);
	prev->rchild = *head;
	prev->rgot = 1;
	(*head)->rchild =prev;
}
void qwe(Note T) {
	Note L = T->lchild;
	while (L != T) {
		while (L->lgot == NULL) {
			L = L->lchild;
		}
		printf("%c\n", L->data);
		while (L->rgot == 1 && L->rchild != T) {
			L = L->rchild;
			printf("%c\n", L->data);
		}
		L = L->rchild;
	}

}
int main() {
	Note head;
	Note T;
	gone(&T);
	run(T, &head);
	qwe(T);
	return 0;
}