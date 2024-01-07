#include <iostream>
using namespace std;
int main()
{
  int  n;
  cout<<"请输入一个日期：";	//0 周末 1-6 周一到周六 
  cin>>n;    // n % 7 == 0-6 
  if(n>=90) {
  	cout<<"今天是星期天。";
  } else if(n>=70){
  	cout<<"B";
  } else if(n>=60){
  	cout<<"C";
  }else{
  	cout<<"D";	
  } 
  return  0;
} 

