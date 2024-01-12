#include <iostream> 
using namespace std;
int main()
{
  int a,b,i;
  cout<<"0.";
  i=1;
  a=1;
  while(i<=100)
  {
    a*=10;
    b=a/7; 
    cout<<b;
    a%=7;
    i++;
  } 
  return 0;
}

