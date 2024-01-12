#include <iostream>
using namespace std;
int main()
{
  float max,x;
  int i;
  cout<<"请输入第1个数:";             
  cin>>x;
  max=x;
  i=2;
  for(;i<=10;i++)
  {
    cout<<"请输入第"<<i<<"个数:";   
    cin>>x;
    if(x>max) max=x;
  }
  cout<<"最大的数："<<max; 
  return 0;
}

