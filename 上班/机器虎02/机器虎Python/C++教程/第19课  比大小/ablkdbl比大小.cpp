#include<bits/stdc++.h>//
using namespace std;
int main()
{ int a,b,t;
cin>>a>>b; 
if(a>b)
{
  t=a;
  a=b;
  b=t;
}
if(b>a)
{
  t=b;
  b=a;
  a=t;
}
cout<<a<<b;












  return 0; }

