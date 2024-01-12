#include <iostream> 
using namespace std;
int main()
{
 int  m,n,r;
  cout<<"输入两个正整数：";
  cin>>m>>n; 
  r=m%n;
  while(r!=0)
  {
  	m=n;
  	n=r;
  	r=m%n;
  }
  cout<<"最大公约数："<<n<<endl;
  return 0; 
}

