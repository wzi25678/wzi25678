#include <iostream>
using namespace std;
int main()
{
  int ge,shi,bai,i;
  cout<<"Ë®ÏÉ»¨Êý"<<endl; 
  for(i=100;i<1000;i++)
  {
    bai=i/100;
  	shi=(i/10)%10;
  	ge=i%10;
  	if (bai*bai*bai+shi*shi*shi+ge*ge*ge==i) 
      cout<<i<<"     "; 
  }
  return 0; 
}

