#include<stdio.h>
#define MAX 0x1000
#define MAX_ZU 100
typedef struct {
	int verter[MAX_ZU];
	int art[MAX_ZU][MAX_ZU];
	int ver_num;
	int edge_num;
}Mat;
void create(Mat* G) {
	G->edge_num = 16;
	G->ver_num = 9;
	for (int i = 0; i < G->ver_num; i++) {
		G->verter[i] = i;
	}
	for (int i = 0; i < G->ver_num; i++) {
		for (int j = 0; j < G->ver_num; j++) {
			if (i == j) {
				G->art[i][j] = 0;
			}
			else {
				G->art[i][j] = MAX;
			}
		}
	}
	G->art[0][1] = 1;
	G->art[0][2] = 5;
	G->art[1][2] = 3;
	G->art[1][3] = 7;
	G->art[1][4] = 5;
	G->art[2][4] = 1;
	G->art[2][5] = 7;
	G->art[3][4] = 2;
	G->art[3][6] = 3;
	G->art[4][5] = 3;
	G->art[4][6] = 6;
	G->art[4][7] = 9;
	G->art[5][7] = 5;
	G->art[6][7] = 2;
	G->art[6][8] = 7;
	G->art[7][8] = 4;
	for (int i = 0; i < G->ver_num; i++) {
		for (int j = 0; j < G->ver_num; j++) {
			G->art[j][i] = G->art[i][j];
		}
	}
}
int choose(int distance[], int found[], int ver_num) {
	int min = MAX;
	int minpos = -1;
	for (int i = 0; i<ver_num; i++) {
		if (distance[i] < min && found[i] == 0) {
			min = distance[i];
			minpos = i;
		}
	}
	return minpos;
}
void dijkstra(Mat G, int degin) {
	int found[MAX_ZU];
	int path[MAX_ZU];
	int distance[MAX_ZU];
	for (int i = 0; i < G.ver_num; i++) {
		found[i] = 0;
		path[i] = -1;
		distance[i] = G.art[degin][i];
	}
	found[degin] = 1;
	distance[degin] = 0;
	int next;
	for (int i = 0; i < G.ver_num; i++) {
		next = choose(distance, found, G.ver_num);
		found[next] = 1;
		for (int j = 0; j < G.ver_num; j++) {
			if (found[j] == 0) {
				if (distance[next] + G.art[next][j] < distance[j]) {
					distance[j] = distance[next] + G.art[next][j];
					path[j] = next;
				}
			}
		}
	}
	for (int i = 1; i < G.ver_num; i++) {
		printf("0-> %d :%d\n", i, distance[i]);
		int j = i;
		printf("%d <-", i);
		while (path[j] != -1) {
			printf("%d <- ", path[j]);
			j = path[j];
		}

		printf("0\n");
	}
}


int main() {
	Mat G;
	create(&G);
	int degin = 0;
	dijkstra(G, degin);
	return 0;
}