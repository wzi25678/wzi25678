#include <iostream>
using namespace std;
int main()
{
  int i;
  for(i=1;i<=20;i++)
  {
    if( i%10==7 || i%7==0 )
    {
      cout<<"��"<<' '; 
      continue;
    }
    cout<<i<<' ';
  }
  return 0;
}


