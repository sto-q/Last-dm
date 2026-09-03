#include<stdio.h>
#include<math.h>
int main() {
	double x1, y1, x2, y2, x3, y3;
	scanf_s("%lf %lf%lf %lf%lf %lf", &x1, &y1, &x2, &y2, &x3, &y3);
	double K1 = pow((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1),0.5);
	double K2 =pow((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2),0.5);
	double K3 = pow((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3), 0.5);
	printf("%f", K1 + K2 + K3);
	return 0;
}
