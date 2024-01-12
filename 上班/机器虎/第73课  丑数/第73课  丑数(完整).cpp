#include <iostream>
#include <iomanip>
using namespace std;
bool choushu(int n)
{
  while(n%2==0)
    n/=2;
  while(n%3==0)
    n/=3;
  while(n%5==0)
    n/=5;
  return (n==1);	 		 	
}
int main()
{
  int num=0;
  for(int i=1;i<=100;i++)
    if(choushu(i))
	{
      cout<<setw(6)<<i;	
      num++;
      if(!(num%10)) cout<<endl;	
	} 
  cout<<endl;
  cout<<"¸öÊý£º"<<num<<endl; 
  return 0;
}
