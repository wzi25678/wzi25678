#include <iostream>
using namespace std;
int main()
{
  int a,b,c,min;
  cout<<"a b c=";
  cin>>a>>b>>c;
  if(a<b)  min=a;
  else  min=b;
  if(c<min)  min=c;
  cout<<"min="<<min<<endl;
  return  0;
}

