#include <iostream>
using namespace std;
int max(int a[],int n)
{
  int t;
  if(n==1)
    t=a[1];
  else
    if(max(a,n-1)>a[n])
      t=max(a,n-1);
    else
      t=a[n];    
  return t;
}
int main()
{
  int a[6];   //为了便于理解，a[0]不用。
  cout<<"请输入5个数："<<endl; 
  for(int i=1;i<=5;++i)
    cin>>a[i];
  cout<<"最大的数是："<<max(a,5)<<endl;
}

