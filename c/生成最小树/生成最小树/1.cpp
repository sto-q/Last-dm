#include<stdio.h>
#define MAX 100
#define MAX_U 0xffffff
typedef struct k {
	int arc[MAX][MAX];
	int vertex[MAX];
	int du;
	int bian;
}Mat;
void ChuShi(Mat*p) {
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
void prim(Mat* p) {
	int i, j, k;
	int min;
	int wight[MAX];
	int vcs_wight[MAX];
	wight[0] = 0;
	vcs_wight[0] = 0;
	for (i = 1; i < p->du; i++) {
		wight[i] = p->arc[0][i];
		vcs_wight[i] = 0;
	}
	for (int i = 1; i < p->du; i++) {
		min = MAX;
		j = 0;
		k = 0;
		while (j < p->du) {
			if (wight[j] != 0 && wight[j] < min) {
				min = wight[j];
				k = j;
			}
			j++;
		}
		printf("%c %c\n", p->vertex[vcs_wight[k]], p->vertex[k]);
		wight[k] = 0;
		for (j = 0; j < p->du; j++) {
			if (wight[j] != 0 && p->arc[k][j] < wight[j]) {
				wight[j] = p->arc[k][j];
				vcs_wight[j] = k;
			}
		}
	}
}
int main() {
	Mat p;
	ChuShi(&p);
	prim(&p);
	return 0;
}