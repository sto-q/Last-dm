#include<stdio.h>
#include<stdlib.h>
#define MAX_lie 50
typedef struct tre {
	char data;
	struct tre* lchild;
	struct tre* rchild;
}tree;
typedef struct Dlie {
	tree** data;
	int to;
	int wei;
}Lie;
typedef tree* Tree;
Lie* chushilie() {
	Lie* p=(Lie*)malloc(sizeof(Lie));
	p->data = ((tree**)malloc(sizeof(tree*) * MAX_lie));
	p->to = 0;
	p->wei = 0;
	return p;
}
int rulie(Lie* p,tree* e) {
	if ((p->wei + 1) % MAX_lie == p->to) {
		printf("manlei");
		return 0;
	}
	p->data[(p->wei) % MAX_lie] = e;
	p->wei = (p->wei + 1) % MAX_lie;
	return 1;
}
int chulie(Lie* p,tree**e) {
	if (p->to == p->wei) {
		return 0;
	}
	*e = p->data[p->to];
	p->to = (p->to + 1) % MAX_lie;
	return 1;
}
char str[] = "ABDH#K###E##CFI###G#J##";
int cot = 0;
void chushishu(Tree*p) {
	char ch=str[cot++];
	if (ch == '#') {
		*p = NULL;
	}
	else {
		*p = (Tree)malloc(sizeof(tree));
		(*p)->data = ch;
		chushishu(&(*p)->lchild);
		chushishu(&(*p)->rchild);
	}
}
int isEop(Lie* p) {
	if (p->to == p->wei) {
		return 0;
	}
	else {
		return 1;
	}
}
int Cout(Lie* p) {
	if (isEop(p)) { 
		if (p->wei >= p->to) {
			return p->wei - p->to;
		}
		else {
			return MAX_lie - p->to + p->wei;
		}
	}
	else {
		return 0;
	}
}
int maxDepth(tree* H) {
	if (H == NULL) {
		return 0;
	}
	int depth = 0;
	Lie* K = chushilie();
	tree* p = H;
	rulie(K,p);
	while (isEop(K)) {
		int count = Cout(K);
		while (count > 0) {
			chulie(K, &p);
			if (p->lchild != NULL) {
				rulie(K, p->lchild);
			}
			if (p->rchild != NULL) {
				rulie(K, p->rchild);
			}
			count--;
		}
		depth++;
	}
	return depth;
}
int main() {
	tree* p;
	chushishu(&p);
	printf("¹²ÓÐ%d²ã", maxDepth(p));
	return 0;
}