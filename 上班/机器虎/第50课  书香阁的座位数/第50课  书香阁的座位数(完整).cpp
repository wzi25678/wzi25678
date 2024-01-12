#include <iostream>
using namespace std; 
int main()
{
  int sum,p,x;
  p=1;
  x=15;
  sum=x;  
  cout<<p<<"  "<<x;
  cout<<"  "<<sum<<endl; 
  do 
  {
    p++;
    x+=2;
    sum+=x;
    cout<<p<<"  "<<x<<"  "<<sum<<endl;
  }while(sum !=312);
  cout<<"最后一排的座位数："<<x<<endl;
  cout<<"排数："<<p<<endl;
  return 0;
}

