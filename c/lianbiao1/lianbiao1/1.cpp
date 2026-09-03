#include<stdio.h>
#include<stdlib.h>
#include"no.h"

//typedef struct _node {
//	int valhde;
//	struct _node* next;
//}Node;
typedef struct _list {
	Node* head;
	Node* tail;
}List;
void add(List* pList, int number);
void print(List*pList);
int main() {
	List list;
	int number;
	list.head = NULL;
		do {
			scanf_s("%d", &number);
			if (number != -1) {
				add(&list, number);
			}
		} while (number != -1);
		print(&list);
		scanf_s("%d", &number);
		//----------------------------------------------------------------------
		//链表的搜索
		Node* p;
		int isFound=0;
		for (p = list.head; p; p = p->next) {
			if (p->value == number) {
				printf("yes");
				isFound = 1;
				break;
			}
		}
		if (!isFound) {
			printf("no");
		}
		//-----------------------------------------------------------------
		//链表的删除
		Node* q;
		for (q = NULL, p = list.head; p; q=p, q = q->next) {
			if (p->value == number) {
				if (q) {
					q->next = p->next;
				}
				free(p);
				break;
			}
		}
//------------------------------------------------------------------------------------
		//释放整个链表
		for (p = list.head; p; p = q) {
			q = p->next;
			free(p);
		}
		return 0;
}//------------------------------------------------------------------------------------
void add(List* pList, int number) {
	Node* p = (Node*)malloc(sizeof(Node));
	p->value = number;
	p->next = NULL;
	Node* last = pList->head;
	if (last) {
		while (last->next) {
			last = last->next;
		}
		last->next = p;
	}
	else {
		pList->head = p;
	}
}
void print(List* pList) {
	Node* p;
	for (p = pList->head; p; p = p->next) {
		printf("%d\t", p->value);
	}
	printf("\n");
}
