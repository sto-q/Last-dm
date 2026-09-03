#include<stdio.h>
#include<easyx.h>
int main() {
	initgraph(900,900);
	setbkcolor(RGB(77, 164, 228));
	cleardevice();
	setfillcolor(RGB(134, 27, 45));
	fillrectangle(250, 250, 350, 350); 
	fillrectangle(400, 250, 500, 350);
	fillellipse(350, 500, 400, 600);
	setlinecolor(RGB(31, 31, 31));
	setlinestyle(PS_DASH, 5);
	circle(375, 375, 250);
	setlinecolor(RGB(255, 51, 115));
	setlinestyle(PS_DASHDOTDOT, 4);
	line(275, 400, 325, 400);
	line(450, 400, 500, 400);
	getchar();
	return 0;
}