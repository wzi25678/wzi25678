#include <iostream>
using namespace std;
int main()
{
  int n,ge,shi;
  cout<<"请输入一个两位数："; 
  cin>>n;
  shi=n/10;
  ge=n%10;
  int temp = shi;
  shi = ge;
  ge = temp;
  cout<<shi<<ge; 
  return 0;
}

