#include <iostream>
#include <cstdlib>  //����system()���� 
#include <string>
using namespace std;
int main()
{
  int i,a[4],ans;
  string t[4];
  t[0]="1,2,3,4,5,6,7";
  t[1]="1,3,5,7";
  t[2]="2,3,6,7";
  t[3]="4,5,6,7";
  cout<<"����������"<<endl; 
  cout<<"����������7�����У�ѡһ�����������"<<endl; 
  cout<<t[0]<<endl;
  system("pause");    //��ͣ 
  for(i=1;i<=3;i++)
  {
    system("cls");  //���� 
    cout<<i<<"�ʣ��������������? 0:û��, 1:��"<<endl; 
    cout<<t[i]<<endl; 
   	do
    {
      cin>>a[i];
    }while(a[i]<0||a[i]>1);
  }
  ans=4*a[3]+2*a[2]+a[1];
  system("cls");
  cout<<"�������������:" ;
  cout<<ans<<endl;  
  return 0;
}

