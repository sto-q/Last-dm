#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 100
typedef int KK;
typedef struct {
	KK  data[MAX];
	int lon;
}LOP;

//遍历
void asd(LOP *L) {
	for (int i = 0; i < L->lon; i++) {
		printf("%d\t", L->data[i]);
	}
	printf("\n");
}
//初始化
void lkj(LOP* L) {
	L->lon = 0;
}
//插入
int qwe(LOP* L, int pot, KK shu) {
	if (pot < 0 || pot > L->lon) {  // 有效范围：0 到 当前长度
		printf("插入位置无效！有效范围：0-%d\n", L->lon);
		return 0;
	}

	// 2. 检查顺序表是否已满
	if (L->lon >= MAX) {
		printf("顺序表已满，无法插入\n");
		return 0;
	}
	if (pot <= L->lon) {
		for (int i = L->lon; i >pot-1; i--) {
			L->data[i ] = L->data[i-1];
		}
		L->data[pot] = shu;
		L->lon++;
	}
	return 1;
}
//删除
void zxc(LOP* L, int Pot) {
	for (int i =Pot; i <L->lon; i++) {
		L->data[i - 1] = L->data[i];
	}
	L->lon--;
}
//查找
int mnb(LOP*L, KK zhi) {
	for (int i = 0; i < L->lon; i++) {
		if (L->data[i] == zhi) {
			return i+1;
		}
	}
	return 0;
}
int main() {
	LOP L;
	lkj(&L);
	int n;
	scanf_s("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf_s("%d", &L.data[i]);
		L .lon++;
	}
	asd(&L);

	// 清空缓冲区中的换行符
	while (getchar() != '\n'); 
	int Q,q;
	char cho;
	printf("是否选择插入一个值? (y/n): ");
	scanf_s("%c", &cho, 1); 

	if (cho == 'y' || cho == 'Y') {
		printf("你选择了插入值\n");
		scanf_s("%d", &Q);
		printf("你选择的位置是:\n");
		scanf_s("%d", &q);
		qwe(&L, q, Q);
		asd(&L);
	}
	else {
		printf("你选择了不插入\n");
		asd(&L);
	}
	// 清空缓冲区中的换行符
	while (getchar() != '\n');
	printf("是否删除一个值? (y/n)：");
	char Cho;
	int M, m;
	scanf_s("%c", &Cho, 1);
	if (cho == 'y' || cho == 'Y') {
		printf("你选择删除的");
		printf("位置是:\n");
		scanf_s("%d", &m);
		zxc(&L, m);
		asd(&L);
	}
	else {
		printf("你选择了不删除\n");
		asd(&L);
	}
	printf("是否选择查找值的位置? (y/n)：");
	// 清空缓冲区中的换行符
	while (getchar() != '\n');
	int k;
	char K;
	scanf_s("%c", &K, 1);
	printf("想查的是:\n");
	scanf_s("%d", &k);
	if (K == 'y' || K == 'Y') {
		printf("位置是:%d", mnb(&L, k));
	}
	return 0;
}