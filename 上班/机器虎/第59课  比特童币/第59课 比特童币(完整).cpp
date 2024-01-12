#include <iostream> 
using namespace std;
int main()
{
  int a1,a2,a3,a4,n;
  for(a4=0;a4<=1;a4++)
    for(a3=0;a3<=1;a3++)	
      for(a2=0;a2<=1;a2++)
        for(a1=0;a1<=1;a1++)
        {
           n=a4*8+a3*4+a2*2+a1*1;
           cout<<a4<<a3<<a2<<a1<<"B    "<<n<<endl;
        }
  return 0;	
}

