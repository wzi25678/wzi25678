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
  cout<<a<<" "<<b<<" "<<c<<endl;	//' '�м���һ���ո�
  return  0;
}

