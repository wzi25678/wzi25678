#include <iostream>
using namespace std; 
int main()
{
  int i,t;//tʱ�䣬 i�߶� 
  t=i=0;
  while(1)
  {
     t=t+1; 
	 i+=3;
	 if (i>=17) break;
	 t++;
	 i--;
  }	
  cout<<"��"<<t<<"����"<<endl;
  return 0; 
}

