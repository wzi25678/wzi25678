#include <iostream>
#include <iomanip>  //Ϊ��ʹ��setw()���������
using namespace std;
int  main()
{
  int  a,b,s;
  a=18;
  b=870;
  s=a+b;
  cout<<setw(10)<<a<<endl;  
  cout<<setw(4)<<'+'<<setw(6)<<b<<endl; 
  cout<<" -----------"<<endl;
  cout<<setw(10)<<s<<endl; 
  return 0;
 } 

