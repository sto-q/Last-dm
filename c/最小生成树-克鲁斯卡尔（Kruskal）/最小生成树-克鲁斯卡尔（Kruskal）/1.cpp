#include<stdio.h>
#define MAX 100
#define MAX_U 0xffffff
typedef struct k {
	int arc[MAX][MAX];
	char vertex[MAX];
	int du;
	int bian;
}Mat;
typedef struct {
	int begin;
	int end;
	int weight;
}Edge;
void ChuShi(Mat* p) {
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
			if (i == j) {
				p->arc[i][j] = 0;
			}
			else {
				p->arc[i][j] = MAX_U;
			}
		}
	}
	p->arc[0][1] = 12;
	p->arc[0][2] = 3;
	p->arc[0][3] = 134;
	p->arc[1][2] = 23;
	p->arc[1][4] = 45;
	p->arc[2][3] = 2;
	p->arc[2][5] = 9;
	p->arc[3][6] = 41;
	p->arc[4][5] = 15;
	p->arc[4][7] = 17;
	p->arc[5][6] = 13;
	p->arc[5][7] = 15;
	p->arc[6][7] = 18;
	for (int i = 0; i < p->du; i++) {
		for (int j = 0; j < p->du; j++) {
			p->arc[j][i] = p->arc[i][j];
		}
	}
}
void sort(Edge* E, int  i,int j) {
	int temp;
	temp = E[i].end;
	E[i].end = E[j].end;
	E[j].end = temp;
	temp = E[i].begin;
	E[i].begin = E[j].begin;
	E[j].begin = temp;
	temp = E[i].weight;
	E[i].weight = E[j].weight;
	E[j].weight = temp;
}
void Sort(Edge E[], int du) {
	for (int i = 0; i < du; i++) {
		for (int j = i + 1; j < du; j++) {
			if (E[i].weight > E[j].weight) {
				sort(E,i,j);
			}
		}
	}
}
int find(int* print, int R) {
	while (print[R] > 0) {
		R = print[R];
	}
	return R;
}
void kruskal(Mat p) {
	Edge H[MAX];
	int k = 0;
	for (int i = 0; i < p.du; i++) {
		for (int j = i + 1; j < p.du; j++) {
			if (p.arc[i][j] < MAX_U) {
				H[k].weight = p.arc[i][j];
				H[k].begin = i;
				H[k].end = j;
				k++;
			}
		}
	}
	Sort(H, p.bian);
	int print[MAX];
	for (int i = 0; i< p.du; i++) {
		print[i] = 0;
	}
	int n, m;
	for (int i = 0; i < p.du; i++) {
		n = find(print,H[i].begin);
		m = find(print,H[i].end);
		if (n != m) {
			print[n] = m;
			printf("%c %c\n", p.vertex[H[i].begin], p.vertex[H[i].end]);
		}
	}
}
int main() {
	Mat p;
	ChuShi(&p);
	kruskal(p);
	return 0;
}