#include<stdio.h>
#include<easyx.h>
// 颜色定义 (具体的根据实际情况来设)
#define PLAYER_WIDTH   40       // 玩家矩形的宽
#define PLAYER_HEIGHT  60       // 玩家矩形的高
#define COLOR_FIRE      RGB(255, 100, 100)   // 火人红色
#define COLOR_WATER     RGB(100, 100, 255)   // 水人蓝色
#define COLOR_WALL      RGB(100, 70, 30)     // 墙壁棕色
#define COLOR_PLATFORM  RGB(150, 120, 80)    // 平台浅棕
#define COLOR_TRAP_FIRE RGB(255, 150, 50)    // 火池橙色
#define COLOR_TRAP_WATER RGB(50, 150, 255)   // 水池蓝色
#define COLOR_TRAP_SPIKE RGB(100, 100, 100)  // 尖刺灰色
#define COLOR_DOOR      RGB(50, 200, 50)     // 门绿色
#define COLOR_BG        RGB(200, 230, 255)   // 背景天蓝色
int main() {
	initgraph(800, 600);
	setfillcolor(COLOR_FIRE);
	fillrectangle(50, 480, 50 + PLAYER_WIDTH, 480 + PLAYER_HEIGHT);//火人
	setfillcolor(COLOR_WATER);
	fillrectangle(150, 480, 150 + PLAYER_WIDTH, 480 + PLAYER_HEIGHT); // 水人
	setfillcolor(COLOR_PLATFORM);
	fillrectangle(0, 540, 800, 600);
	fillrectangle(400, 300, 800, 400);// 平台
	setfillcolor(COLOR_TRAP_FIRE);
	fillrectangle(200, 540, 300, 600);// 火池
	setfillcolor(COLOR_TRAP_WATER);
	fillrectangle(400, 540, 500, 600);// 水池
	setfillcolor(COLOR_TRAP_SPIKE);
	fillrectangle(500, 300, 600, 360);// 尖刺
	setfillcolor(COLOR_DOOR);
	fillrectangle(700, 200, 800, 300); // 门
	outtextxy(10, 10, "关卡数:");
	char str[] = "A W D分别为左_跳跃_右";
	outtextxy(500, 10, str);
	getchar();
	return 0;
}