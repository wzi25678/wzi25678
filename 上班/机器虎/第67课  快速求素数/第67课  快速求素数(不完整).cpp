#include <iostream> 
#include <iomanip>
using namespace std;
int main()
{
  int a[101];
  int i,j,num;
  for(i=2;i<=100;i++)
    a[i]=true;
  a[0]=a[1]=false; 
  i=1; 
 
 
  cout<<endl;
  cout<<"100以内素数个数："<<num<<endl;
  return 0;
}

