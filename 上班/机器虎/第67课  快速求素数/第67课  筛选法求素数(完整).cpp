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
  do
  {
    i++;
    if(a[i])
    {
      for(j=2;j<=100/i;j++)
        a[i*j]=false;
    }
  }while(i<100); 
  num=0;
  for(i=1;i<=100;i++)
  {  
    if(a[i])
    {
      cout<<setw(6)<<i; 
      num++;
      if(num%10==0) cout<<endl;	
    } 
  }
  cout<<endl;
  cout<<"100以内素数个数："<<num<<endl;
  return 0;
}

