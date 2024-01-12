#include <iostream>
using namespace std;
int main()
{
  int a[6],i,j,t;  
  cout<<"输入5个整数:"<<endl; 
  for(i=1;i<=5;i++)
    cin>>a[i]; 
  for(i=1;i<=4;i++)
    for(j=1;j<=5-i;j++)
      if(a[j]<a[j+1])	
      {
        t=a[j];
        a[j]=a[j+1];
        a[j+1]=t;
      }
  for(i=1;i<=5;i++)
    cout<<a[i]<<"  ";
  return  0; 
}

