#include <iostream>
using namespace std;	//standard
int main()	//int-> integer 
{
  char  n;	//character
  cout<<"����a~z:";	//input/output  
  /*
  ASCII�룺
  	�ַ��и���Ӧ�ı��
	�����ַ�   0-9    48-57
	space�ո�    32 
	Ӣ����ĸ	A-Z   65-90    a-z    97-122 
	97  65  32    	
	122 90  32
	������š�������   
  */
  cin>>n;
  n=n-32;
  cout<<n<<endl;
  return 0;
}
