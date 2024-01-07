#include <iostream>
using namespace std;
int main()
{
  int a,b,c,temp;
  cout<<"a,b,c="<<endl;
  cin>>a>>b>>c;
  if(a>b){
    temp=a;        
  	a=b;
  	b=temp;
  }
  if(a>c){
  	temp=a;
  	a=c;
  	c=temp; 
  }
  if(b>c) {
  	temp=b;
  	b=c;
  	c=temp; 
  }
  cout<<a<<" "<<b<<" "<<c<<endl;	//' '中间有一个空格
  return  0;
}

