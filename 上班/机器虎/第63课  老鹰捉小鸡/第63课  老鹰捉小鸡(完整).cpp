#include <iostream>
using namespace std;
int main()
{
  int i,j,a[6],n;
  for(i=1;i<6;i++)
    a[i]=i;
  //�����1�ε�λ��
  i=1;
  cout<<i<<":  "; 
  for(j=1;j<6;j++) 
    cout<<a[j]<<"  ";	
  cout<<endl;
  for(i=2;i<=10;i++)
  {
    //�ƶ�λ��
    for(j=0;j<=4;j++)
      a[j]=a[j+1];
    a[5]=a[0];
    //���λ��
    cout<<i<<":  "; 
    for(j=1;j<=5;j++)
      cout<<a[j]<<"  ";
    cout<<endl;  
  }
  return 0;
}

