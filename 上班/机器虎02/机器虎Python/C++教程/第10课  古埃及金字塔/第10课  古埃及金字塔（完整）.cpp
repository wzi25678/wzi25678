#include <iostream>
using namespace std;
int main()
{
  int a,h;
  float  s;
  cout<<"a,h=";
  cin>>a>>h;
  s=a*h/2.0;  //这里要写实数2.0，不能写成整数2
  cout<<"s="<<s<<endl;   
  return 0;
}

