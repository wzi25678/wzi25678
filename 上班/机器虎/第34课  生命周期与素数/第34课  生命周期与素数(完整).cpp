#include <iostream>
using namespace std; 
int main()
{
  long long i,n; 
  bool flag;
  cout<<"n=";
  cin>>n;//9 
  flag=true;
  for(i=2;i<n;i++)
    if(n%i==0) 
    {
      flag=false;
      break;
    } 
  if(flag) cout<<"是素数";
  else cout<<"不是素数";
  return 0;
}

