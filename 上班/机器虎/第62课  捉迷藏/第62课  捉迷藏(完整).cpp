#include <iostream>
using namespace std;
int main()
{
  bool a[11];   
  int i,cishu;
  for(i=1;i<=10;i++)
    a[i]=true;
  i=10;
  a[i]=false; 
  cishu=1;
  while(cishu<=1000)
  {
    i=(i+cishu)%10; 
    if(i==0) i=10;
    a[i]=false; 
    cishu++;
  }
  for(i=1;i<=10;i++)
    if(a[i]) cout<<i<<endl;
  return 0;
}

