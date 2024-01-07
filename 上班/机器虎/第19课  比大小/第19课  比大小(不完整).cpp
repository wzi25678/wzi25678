#include <iostream>
using namespace std;
int main()
{
  int a,b,c;
  cin>>a>>b>>c;
  int max = 0;
  //> >= < <= == !=
  if(a>=b){
  	max = a; 
  }else{
  	max = b;
  }
  if(max >= c){
  	cout<<max;
  }else{
  	cout<<c;
  }
  return 0;                                                
} 

