#include <iostream>
using namespace std;
int maxn(int b[],int m)
{
  bool p=true;
  int x,num,i=0;
  while(p)
  {
    x=b[i];
    num=0;
    for(int j=0;j<10;j++)
      if(x<b[j]) num++;
    if(num==m-1) 
      p=false;
    else
      i++;
  }
  return x;
}
int main()
{
  int n,a[10]={99,200,95,87,98,-12,30,87,75,-25};
  do
  {
    cin>>n; 
  }while(n<1||n>10);
  cout<<maxn(a,n)<<endl;  //数组名作为实参
  return 0;
}

