#include <iostream>
using namespace std;
int main()
{
  bool flag;
  int year;
  cout<<"������һ����ݣ�";
  cin>>year;
  if((year%4==0&&year%100!=0)||year%400==0)
    flag=true;
  else
    flag=false;
  if(flag)	          
    cout<<year<<"������"<<endl;
  else
    cout<<year<<"��ƽ��"<<endl;
  return 0;
} 


