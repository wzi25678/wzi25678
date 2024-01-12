#include <iostream>                      
using namespace std;   
int zuoye(int n)
{  
  if(n==7)
    return 1;
  else
    return zuoye(n+1)+1;
}
int main()
{
  cout<<zuoye(1)<<endl;
  return 0;
}

