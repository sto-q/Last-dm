#include<stdio.h>
#include<stdint.h>
struct abc {
	int a: 2;  // 成员a占用2个二进制位
	int b: 3;  // 成员b占用3个二进制位
};
int main() {
    struct abc var;
    var.a = 5;  // 101 in binary, but only 2 bits are stored, so it becomes 01 (1 in decimal)
    var.b = 5;
    printf("a = %zd\n", sizeof(struct abc));
    printf("var.a = %d\n", var.a);  // Output will be 1
    printf("var.b = %d\n", var.b);  // Output will be 5
    return 0;
}