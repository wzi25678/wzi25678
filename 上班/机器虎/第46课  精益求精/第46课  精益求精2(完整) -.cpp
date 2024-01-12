#include <iostream>
using namespace std;
int main()
{
  int m,n,r,i=1;
  m=1;
  n=7;
  cout<<m/n<<'.';
  r=m%n;
  while(i<=100)
  {
    cout<<(r*10)/n;
  	r=(r*10)%n;
  	i++;
  }
  return 0;	
}


