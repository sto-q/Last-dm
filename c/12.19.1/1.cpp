#include<stdio.h>
#include<stdlib.h>
typedef struct k {
	char data;
	struct k* rchild;
	struct k* lchild;
}tree;
#define  Tree tree*
tree* create() {
	tree* p = (Tree)malloc(sizeof(tree));
	p->lchild = NULL;
	p->rchild = NULL;
	return p;
}
char syp[] = { "ABDH#K###E##CFI###G#J##" };
int str = 0;
void createtree(Tree* p) {
	char K = syp[str++];
	if (K == '#') {
		*p = NULL;
	}
	else {
		*p = (Tree)malloc(sizeof(tree));
		(*p)->data = K;
		createtree(&(*p)->lchild);
		createtree(&(*p)->rchild);
	}

}
void ZhongBl(Tree p) {
	if (p == NULL)return;
	ZhongBl(p->lchild);
	ZhongBl(p->rchild);
	printf("%c", p->data);
}
int main() {
	Tree p = create();
	createtree(&p);
	ZhongBl(p);
	return 0;
}
