#include <iostream>
#include <iomanip>  //为了使用setw()来设置域宽
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

