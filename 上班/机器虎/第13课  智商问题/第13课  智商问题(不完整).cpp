#include <iostream>
using namespace std;
int main()
{
  cout<<"IQ:"; 
  /*
  һ��if -else if  -else
  ����switch...case 
  */ 
  int iq;
  cin>>iq;              
  if(iq>=200){
  	cout<<"genius��";
  }else if(iq >140){
  	cout<<"�廪��������";
  }else if(iq >100){
  	cout<<"Ȫ���������ˣ�";
  }else if(iq>50){
  	cout<<"����Ŭ����";
  }else{
  	cout<<"�ؼ�ϴϴ���Ͻ�˯��";
  }         
  //���   
  return 0;
}


