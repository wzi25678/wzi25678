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
  int a[6];   //Ϊ�˱�����⣬a[0]���á�
  cout<<"������5������"<<endl; 
  for(int i=1;i<=5;++i)
    cin>>a[i];
  cout<<"�������ǣ�"<<max(a,5)<<endl;
}

