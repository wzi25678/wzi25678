#include <iostream>
using namespace std;
int main()
{
  int a,b,c,d,e; 
  int t;  //temp(orary)
  cin>>a>>b>>c>>d>>e;
  t = a;
  a = b;
  b = c;
  c = d;
  d = e;
  e = t;
  cout<<a<<b<<c<<d<<e;  //���������a,b��ֵ
  return 0;
}

