#include <iostream>
using namespace std;
int main()
{
  float max,x;
  int i;
  cout<<"�������1����:";             
  cin>>x;
  max=x;
  i=2;
  for(;i<=10;i++)
  {
    cout<<"�������"<<i<<"����:";   
    cin>>x;
    if(x>max) max=x;
  }
  cout<<"��������"<<max; 
  return 0;
}

