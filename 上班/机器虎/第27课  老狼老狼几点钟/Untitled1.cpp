#include<iostream>
#include <cmath> 
using namespace std;

int main()
{
	// �������߷��� (x^2+y^2-a)^3 - x^2 y^3 = 0
	int a = 1;
	// �����ͼ�߽�
	double bound = 1.3 * sqrt(a);

	// x��y����仯����
	double step = 0.05;

	for ( double y = bound; y >= -bound; y -= step)
	{
		for (double x = -bound; x <= bound; x += step)
		{
			double result = pow((pow(x, 2) + pow(y, 2) - a), 3) - pow(x, 2) * pow(y, 3);
			if (result <= 0)
				cout << "*";
			else
				cout << " ";
		}
		cout << endl;
	}

	cin.get();
}
