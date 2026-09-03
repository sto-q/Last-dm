#include<stdio.h>
#include<stdlib.h>
#define MEshu Eshu*
char arc[] = { "ABDGJ####EH#K###C#FI### " };
int count = 0;
typedef struct k {
	char data;
	struct k* rchild;
	struct k* lchild;
}Eshu;
Eshu* Chushi() {
	Eshu* p = (Eshu*)malloc(sizeof(Eshu));
	p->lchild = NULL;
	p->rchild = NULL;
	return p;
}
void Q(MEshu* p) {
	char e;
	e = arc[count++];
	if (e == '#') {
		*p = NULL;
	}
	else {
		*p = (Eshu*)malloc(sizeof(Eshu));
		(*p)->data = e;
		Q(&(*p)->lchild);
		Q(&(*p)->rchild);
	}
}
void qianBL(Eshu* p) {
	if (p == NULL) {
		return;
	}
	printf("%c  ", p->data);
	qianBL(p->lchild);
	qianBL(p->rchild);
}
int main() {
	Eshu* p = Chushi();
	Q(&p);
	qianBL(p);
	return 0;
}