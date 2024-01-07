#include <iostream>
using namespace std;
int main()
{
  long long sum,n;   // long long为长整型
  int i;
  sum=0;
  n=1;
  for(i=1;i<=62;i++)
  {
     n*=2;
  	 sum+=n;
     cout<<i<<"   "<<n<<endl;
  }
  cout<<"总数："<<sum<<endl;
  return 0;
}

