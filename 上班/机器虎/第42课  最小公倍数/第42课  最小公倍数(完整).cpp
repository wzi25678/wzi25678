#include <iostream>
using namespace std;
int main()
{  
  int x,y,temp,s,i=1;
  cout<<"请输入两个自然数：";
  cin>>x>>y;
  if(x>y)
  {
    temp=x;
    x=y;
    y=temp;
  }
  s=y*i;
  while(s%x!=0)
  {
    i++;
    s=y*i;
  }
  cout<<"最小公倍数："<<s<<endl; 
  return 0; 
}

