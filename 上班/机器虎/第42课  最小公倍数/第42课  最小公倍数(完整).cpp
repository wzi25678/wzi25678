#include <iostream>
using namespace std;
int main()
{  
  int x,y,temp,s,i=1;
  cout<<"������������Ȼ����";
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
  cout<<"��С��������"<<s<<endl; 
  return 0; 
}

