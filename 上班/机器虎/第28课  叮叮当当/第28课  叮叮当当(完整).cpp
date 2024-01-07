#include <iostream>
using namespace std;
int main()
{
  int i;
  for(i=1;i<21;i++)
  {
    cout<<i<<' ';            //' '中有1个空格 
   	if(i%2==0) cout<<"叮叮";
    if(i%3==0) cout<<"当当";
    if(i%2==0||i%3==0) cout<<endl; 
  }	
  return 0;
}

