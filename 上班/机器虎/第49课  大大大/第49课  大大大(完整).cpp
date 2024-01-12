#include <iostream> 
#include <cmath> //调用求浮点数的绝对值函数fabs() 
using namespace std;
int main()
{
  double x,y;
  long long num;
  cout<<"请输入一个纯小数"<<endl; 
  do
  {
    cout<<"x=";
    cin>>x;
  }while(x>=1||x<=0);
  num=1;
  do
  {
    num*=10;
    y=x*num;
  }while(fabs(y-(int)y)>1e-9);
  cout<<int(y)<<endl;
  return 0;
}

