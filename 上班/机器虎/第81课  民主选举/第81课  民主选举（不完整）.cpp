#include <iostream>
using namespace std;
const int MAX=5;      //��ѡ�˵�����
int count(int b[],int n)
{
  int x;
  for(int i=1;i<=n;i++)
  {
    do 
    {
      cout<<i<<':';
      cin>>x;
    }while(x<0||x>MAX);
    b[x]++;
  }
}
int main()
{  
  int a[MAX+1],i,n ,*p;  //a[0]ͳ����Ȩ��Ʊ��
  cout<<"������ʵ��������";
  cin>>n;



 
  p=a; //ָ�����p����ָ��������Ԫ��
  count(p,n);
  for(i=0;i<=MAX;i++)
  {
    switch(i)
    {
      case 0:cout<<"��Ȩ:"<<a[i]<<endl;break;
      default:cout<<i<<"��Ʊ��:"<<a[i]<<endl;break;
    }
  }
  return 0;
}

