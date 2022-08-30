#include <stdio.h>

int main(void)
{
	int a, b, c, d, e, f, sum ;
	
	scanf("%1d %1d %1d", &a,&b,&c);
	scanf("%1d %1d %1d", &d,&e,&f);
	int num1 = a * 100 + b * 10 + c;
	
	int result1 = f * num1;
	printf("%d\n", result1);

	e *= 10;
	int result2 = e * num1;
	printf("%d\n", result2/10);

	d *= 100;
	int result3 = d * num1;
	printf("%d\n", result3/100);

	sum = result1 + result2 + result3;
	printf("%d\n", sum);
	
	return 0;
}