#include <iostream>
using namespace std;
int main()
{
  int i;
  for(i=1;i<21;i++)
  {
    cout<<i<<' ';            //' '����1���ո� 
   	if(i%2==0) cout<<"����";
    if(i%3==0) cout<<"����";
    if(i%2==0||i%3==0) cout<<endl; 
  }	
  return 0;
}

