#include<stdio.h>
#define MAX 100
int main() {
	int MIN[MAX][MAX] = { 0 };
	int n, m, k;
	scanf_s("%d %d %d", &n, &m, &k);
	int HUOx[MAX] = { 0 };
	int HUOy[MAX] = { 0 };
	for (int i = 0; i < m; i++) {
		scanf_s("%d %d",&HUOx[i], &HUOy[i]);
		HUOx[i]--;
		HUOy[i]--;
	}
	int YINx[MAX] = { 0 };
	int YINy[MAX] = { 0 };
	for (int i = 0; i < k; i++) {
		scanf_s("%d %d",&YINx[i],&YINy[i]);
		YINx[i]--;
		YINy[i]--;
	}
	for (int j = 0; j < m; j++) {
		for (int g = -1; g <= 1; g++) {
			for (int s = -1; s <= 1; s++) {
				int x = HUOx[j] + g;
				int y = HUOy[j] + s;
				if (x >= 0 && x < n && y >= 0 && y < n) {
					if (g == 0 && s == 0) {
						MIN[x][y] = 2;
					}
					else {
						MIN[x][y] = 1;
					}
				}
			}
		}
		int extensions[4][2] = {
			 {2, 0},
			 {-2, 0},
			 {0, 2},
			 {0, -2}
		};
		for (int idx = 0; idx < 4; idx++) {
			int x = HUOx[j] + extensions[idx][0];
			int y = HUOy[j] + extensions[idx][1];
			if (x >= 0 && x < n && y >= 0 && y < n) {
				MIN[x][y] = 1;
			}
		}
	}
	for (int h = 0; h < k; h++) {
		for (int p = -2; p <=2; p++) {
			for (int j = -2; j <= 2; j++) {
				if (YINx[h]  + j >= 0 && YINx[h] + j < n && YINy[h]  + p >= 0 && YINy[h] + p < n)
					if (p == 0 && j == 0) {
						MIN[YINx[h] + j][YINy[h] + p] = 2;
					}
					else {
					MIN[YINx[h] + j][YINy[h] + p] = 1;
				}
			}
		}
	}
	int count = 0;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <n; j++) {
			if (MIN[i][j] == 0) {
				count++;
			}
		}
	}
	printf("%d", count);
	return 0;
}
/**
* #include <stdio.h>
#include <string.h>

#define MAXN 105

int light[MAXN][MAXN];  // 1 表示被照亮
int source[MAXN][MAXN]; // 1 表示是光源（火把或萤石）

// 火把的照射模板 (相对坐标 dx, dy)，1 表示亮，0 表示暗
int torch_pattern[5][5] = {
    {0, 0, 1, 0, 0},
    {0, 1, 1, 1, 0},
    {1, 1, 1, 1, 1},
    {0, 1, 1, 1, 0},
    {0, 0, 1, 0, 0}
};

int n, m, k;
int ans = 0;

// 检查坐标是否在地图内
int in_map(int x, int y) {
    return x >= 1 && x <= n && y >= 1 && y <= n;
}

// 放置火把
void place_torch(int x, int y) {
    source[x][y] = 1;
    for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 5; j++) {
            if (torch_pattern[i][j]) {
                int nx = x + i - 2; // 中心在 (x,y)，模板中心在 [2][2]
                int ny = y + j - 2;
                if (in_map(nx, ny)) {
                    light[nx][ny] = 1;
                }
            }
        }
    }
}

// 放置萤石（照亮 5x5 全部）
void place_stone(int x, int y) {
    source[x][y] = 1;
    for (int i = -2; i <= 2; i++) {
        for (int j = -2; j <= 2; j++) {
            int nx = x + i;
            int ny = y + j;
            if (in_map(nx, ny)) {
                light[nx][ny] = 1;
            }
        }
    }
}

int main() {
    scanf("%d%d%d", &n, &m, &k);
    
    memset(light, 0, sizeof(light));
    memset(source, 0, sizeof(source));
    
    int x, y;
    for (int i = 0; i < m; i++) {
        scanf("%d%d", &x, &y);
        place_torch(x, y);
    }
    for (int i = 0; i < k; i++) {
        scanf("%d%d", &x, &y);
        place_stone(x, y);
    }
    
    // 统计怪物数量：没被照亮且不是光源
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (!light[i][j] && !source[i][j]) {
                ans++;
            }
        }
    }
    
    printf("%d\n", ans);
    
    return 0;
}-
*/