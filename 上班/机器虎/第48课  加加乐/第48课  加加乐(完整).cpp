#include <iostream>
using namespace std;
int main()
{
  long long n; 
  int a,sum=0; 
  cout<<"n=";
  cin>>n;
  do
  {
    a=n%10;
    sum+=a;
    n=n/10;
  }while(n!=0);
  cout<<"������λ֮�ͣ�"<<sum<<endl;
  return 0;
}

