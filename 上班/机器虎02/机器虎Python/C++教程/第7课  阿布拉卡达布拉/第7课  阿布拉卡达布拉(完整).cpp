#include <iostream>
using namespace std;
int main()
{
  int a,b,t; 
  a=10;
  b=20; 
  cout<<"a="<<a<<"  b="<<b<<endl;  //�������ǰa,b��ֵ 
  t=a;
  a=b;
  b=t;
  cout<<"a="<<a<<"  b="<<b<<endl;  //���������a,b��ֵ
  return 0;
 }

