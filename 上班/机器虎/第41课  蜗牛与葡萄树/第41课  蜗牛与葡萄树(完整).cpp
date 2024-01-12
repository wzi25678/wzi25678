#include <iostream>
using namespace std; 
int main()
{
  int i,t;//t时间， i高度 
  t=i=0;
  while(1)
  {
     t=t+1; 
	 i+=3;
	 if (i>=17) break;
	 t++;
	 i--;
  }	
  cout<<"需"<<t<<"分钟"<<endl;
  return 0; 
}

