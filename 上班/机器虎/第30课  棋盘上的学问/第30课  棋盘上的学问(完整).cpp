#include <iostream>
using namespace std;
int main()
{
  long long sum,n;   // long longΪ������
  int i;
  sum=0;
  n=1;
  for(i=1;i<=62;i++)
  {
     n*=2;
  	 sum+=n;
     cout<<i<<"   "<<n<<endl;
  }
  cout<<"������"<<sum<<endl;
  return 0;
}

