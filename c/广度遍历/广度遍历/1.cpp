#include<stdio.h>
#define MAX 100
typedef struct k {
	char vertex[MAX];
	int Eshuzu[MAX][MAX];
	int du;
	int bian;
}Mat;
int jianC[MAX];
int rear = 0;
int front = 0;
int queue[MAX];
void chuShitu(Mat* p) {
	p->du = 8;
	p->bian = 13;
	p->vertex[0] = 'A';
	p->vertex[1] = 'B';
	p->vertex[2] = 'C';
	p->vertex[3] = 'D';
	p->vertex[4] = 'E';
	p->vertex[5] = 'F';
	p->vertex[6] = 'G';
	p->vertex[7] = 'H';
	for (int i = 0; i < p->du; i++) {
		for (int j = 0; j < p->du; j++) {
			p->Eshuzu[i][j] = 0;
		}
	}
	p->Eshuzu[0][1] = 1;
	p->Eshuzu[0][2] = 1;
	p->Eshuzu[0][3] = 1;
	p->Eshuzu[1][2] = 1;
	p->Eshuzu[1][4] = 1;
	p->Eshuzu[2][3] = 1;
	p->Eshuzu[2][5] = 1;
	p->Eshuzu[3][6] = 1;
	p->Eshuzu[4][5] = 1;
	p->Eshuzu[4][7] = 1;
	p->Eshuzu[5][6] = 1;
	p->Eshuzu[5][7] = 1;
	p->Eshuzu[6][7] = 1;
	for (int i = 0; i < p->du; i++) {
		for (int j = 0; j < p->du; j++) {
			p->Eshuzu[j][i] = p->Eshuzu[i][j];
		}
	}
}
void bfs(Mat* p) {
	int i = 0;
	jianC[i] = 1;
	queue[rear] = i;
	rear++;
	printf("%c ", p->vertex[i]);
	while (rear != front) {
		i = queue[front];
		front++;
		for (int j = 0; j < p->du; j++) {
			if (p->Eshuzu[i][j] == 1 && jianC[j] == 0) {
				jianC[j] = 1;
				printf("%c ", p->vertex[j]);
				queue[rear] = j;
				rear++;
			}
		}
	}
}
int main() {
	Mat Q;
	chuShitu(&Q);
	for (int i = 0; i < Q.du; i++) {
		jianC[i] = 0;
	}
	bfs(&Q);
	return 0;
}