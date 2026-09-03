#include<stdio.h>
#include<easyx.h>
#include<time.h>
#include <conio.h>
#define EX_DBLCLKS
int main() {
	initgraph(640, 480, EX_SHOWCONSOLE);//创建一个窗口
	setbkcolor(RGB(151, 191, 92));//设置窗口颜色
	//setfillcolor(RGB(219, 133, 121));
	setfillcolor(RGB(159, 97, 167));//球的颜色
	int x = 50;
	int y = 50;
	int r = 20;
	//float vy = 0.0f;
	//	float gravity = 0.3f;  // 添加重力
	int vy = 0;
	int  gravity = 1;
	int  vx = 0;
	int speed = 5;
	int isJumping = 0;
	//const clock_t fps = 1000 / 60;
	int starttime = 0;
	int freamTime = 0;
	while (true) {
		ExMessage msg = { 0 };
		if (peekmessage(&msg, EX_MOUSE | EX_KEY)) {
			if (msg.message == WM_KEYDOWN) {
				switch (msg.vkcode) {
				case VK_LEFT:
					vx = -1;
					break;
				case VK_RIGHT:
					vx = 1;
					break;
				case VK_SPACE:  // 空格键跳跃
					if (!isJumping) {
						vy = -15;  // 跳跃力度
						isJumping = 1;
					}
					break;
				}
			}
			else if (msg.message == WM_KEYUP) {
				switch (msg.vkcode) {
				case VK_LEFT:
				case VK_RIGHT:
					vx = 0;  // 松开按键停止移动
					break;
				}
			}
		}Sleep(5);
		/*clock_t frameTime = clock() - starttime;
		int delayTime = fps - (int)frameTime;
		if (delayTime > 0) {
			Sleep(delayTime);
		}*/
		vy += gravity;
		x += vx * speed;
		y += vy;
		BeginBatchDraw();
		cleardevice();//清屏
		solidcircle(x, y, r);
		solidrectangle(100, 440, 640, 480);
		solidrectangle(400, 350, 640, 390);
		EndBatchDraw();
		// === 边界检测 ===
	   // 底部
		if (y + r >= 480) {
			y = 480 - r;
			vy = 0;
			isJumping = 0;
		}
		// 顶部
		if (y - r <= 0) {
			y = r;
			vy = 0;
		}
		// 左右
		if (x - r <= 0) {
			x = r;
		}
		if (x + r >= 640) {
			x = 640 - r;
		}
		if (y + r >= 440 && x + r >= 100) {
			y = 440 - r;
			vy = 0;
			isJumping = 0;
		}
		if (y - r <= 390 && y + r >= 350 && x + r >= 400) {
			vy = 0;
			y = 350 - r;
			vy = 0;
			isJumping = 0;
		}
		
	}
	return 0;
}