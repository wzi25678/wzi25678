#include <iostream>
using namespace std;
int main()
{
  int i,top,a[31],num=0,k=0;
  for(i=1;i<=30;i++)
    a[i]=0;
  top=1;
  i=top;
  while(num<15) 
  {                            
    if(i>30)  i=1;
    if(a[i]==0)  k++;
    if(k==9)
    {
      a[i]=1;
      k=0;
      num++;
    }
    i++;
  }
  cout<<"骨头所在的位置："; 
  for(i=1;i<=30;i++)
	if(a[i]==0) cout<<i<<"  "; 
  return 0;
}

