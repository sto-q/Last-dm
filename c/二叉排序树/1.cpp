#include<stdio.h>
#include<stdlib.h>
typedef struct k {
	int data;
	struct k *lchild;
	struct k* rchild;
}shu;
#define Shu shu*
int search_bst(Shu T, int value, Shu parent, Shu* pos) {
	if (T == NULL) {
		*pos = parent;
		return 0;
	}
	if (T->data == value) {
		*pos = T;
		return 1;
	}
	if (T->data > value) {
		return search_bst(T->lchild, value, T, pos);
	}
	else {
		return search_bst(T->rchild, value, T, pos);
	}
}
int insere_bst(Shu* T, int value) {
	Shu parent;
	Shu pos;
	Shu curr;
	int status = search_bst(*T, value, NULL, &pos);
	if (status == 0) {
		curr = (Shu)malloc(sizeof(shu));
		curr->data = value;
		curr->lchild = NULL;
		curr->rchild = NULL;
		if (pos == NULL) {
			*T = curr;
		}
		else if (value < pos->data) {
			pos->lchild = curr;
		}
		else { pos->rchild = curr;
		}
		return 1;
	}
	else {
		return 0;
	}
}
int dlete(Shu* T) {
	Shu temp;
	Shu retcod;
	if ((*T)->rchild == NULL) {
		temp = *T;
		*T = (*T)->lchild;
		free(temp);
	}
	else if ((*T)->lchild == NULL) {
		temp = *T;
		*T = (*T)->rchild;
		free(temp);
	}
	else {
		temp = *T;
		retcod = (*T)->lchild;
		while (retcod->rchild != NULL) {
			temp = retcod;
			retcod = retcod->rchild;
		}
		(*T)->data = retcod->data;
		if (temp != *T) {
			temp->lchild = retcod->lchild;
		}
		else {
			temp->rchild = retcod->lchild;
		}
		free(retcod);
	}
	return 1;
}
int diet_bst(Shu* T, int value) {
	if (*T == NULL) {
		printf("no\n");
	}
	else if ((*T)->data == value) {
		return dlete(T);
	}else if((*T)->data>value){
		return diet_bst(&(*T)->lchild, value);
	}
	else {
		return diet_bst(&(*T)->rchild, value);
	}
}

void post(Shu T) {
	if (T== NULL) {
		return ;
	}
	printf("%d ", T->data);
	post(T->lchild);
	post(T->rchild);
}


int main() {
	Shu T = NULL;
	int sum[] = { 12,23,34,45,56,67,78,89,90,65,54,67,98 };
	for (int i = 0; i< sizeof(sum) / sizeof(sum[0]); i++) {
		insere_bst(&T, sum[i]);
	}
	post(T);
	printf("\n");
	diet_bst(&T, 23);
	post(T);
	return 0;
}