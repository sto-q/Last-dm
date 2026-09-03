#include<stdio.h>
#define MAX 100
typedef struct k {
	char vertex[MAX];
	int Eshuzu[MAX][MAX];
	int du;
	int bian;
}Mat;
int jianC[MAX];
void chuShitu(Mat* p) {
	p->du = 8;
	p->bian = 13;
	p->vertex[0] = 'A';
	p->vertex[1] = 'B';
	p->vertex[2] = 'C';
	p->vertex[3] = 'D';
	p->vertex[4] = 'E';
	p->vertex[5] = 'F';
	p->vertex[7] = 'G';
	p->vertex[6] = 'H';
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
void dfs(Mat* p, int e) {
	jianC[e] = 1;
	printf("%c ", p->vertex[e]);
	for (int j = 0; j < p->du; j++) {
		if (p->Eshuzu[e][j] == 1 && jianC[j] == 0) {
			dfs(p, j);
		}
	}
}
int main() {
	Mat Q;
	chuShitu(&Q);
	for (int i = 0; i < Q.du; i++) {
		jianC[i] = 0;
	}
	dfs(&Q, 0);
	return 0;
}