#include <iostream>
using namespace std;
int main()
{
  int  n;
  cout<<"������һ�����ڣ�";	//0 ��ĩ 1-6 ��һ������ 
  cin>>n;    // n % 7 == 0-6 
  if(n>=90) {
  	cout<<"�����������졣";
  } else if(n>=70){
  	cout<<"B";
  } else if(n>=60){
  	cout<<"C";
  }else{
  	cout<<"D";	
  } 
  return  0;
} 

