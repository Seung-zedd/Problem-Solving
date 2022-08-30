#include <stdio.h>

int main(void)
{
	//윤년:(연도 % 4 ==0) && 연도 % 100 !=0 || 연도 % 400 == 0

	int year;
	scanf("%d", &year);

	int leap_year = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

	if (leap_year == 1) printf("%d\n", leap_year);
	else printf("%d\n", leap_year);

	return 0;
}