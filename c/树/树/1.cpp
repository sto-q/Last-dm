#include<stdio.h>
#include<stdlib.h>
typedef struct k {
	char data;
	struct k* lchild;
	struct k* rchild;
}shu;
typedef shu* Shu;
char str[] = "ABDH#K###E##CFI###G#J##";
int cot = 0;
void qwe(Shu* p) {
	char ch;
	ch=str[cot++];
	if (ch == '#') {
		*p = NULL;
	}
	else {
		*p = (Shu)malloc(sizeof(shu));
		(*p)->data = ch;
		qwe(&(*p)->lchild);
		qwe(&(*p)->rchild);
	}
}
void asd1(Shu p) {
	if (p == NULL) {
		return;
	}
	printf("%c", p->data);
	asd1(p->lchild);
	asd1(p->rchild);
}
void asd2(Shu p) {
	if (p == NULL) {
		return;
	}
	asd2(p->lchild);
	printf("%c", p->data);
	asd2(p->rchild);
}
void asd3(Shu p) {
	if (p == NULL) {
		return;
	}
	asd3(p->lchild);
	asd3(p->rchild);
	printf("%c", p->data);
}
int main() {
	Shu last;
	qwe(&last);
	asd1(last);
	printf("\n");
	asd2(last);
	printf("\n");
	asd3(last);
	return 0;
}