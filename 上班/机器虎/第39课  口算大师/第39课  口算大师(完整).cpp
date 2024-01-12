#include <iostream>  
#include <ctime>  
#include <cstdlib>  
using namespace std;  
int main()  
{  
  srand(time(0));
  int x,y,symbol,ans;
  int n,temp,sum=0;   
  for(int i=0; i<10; i++)  
  {  
    x=rand()%9+1;  
    y=rand()%9+1;  
    symbol=rand()%2;  
    if(x<y&&symbol==1) 
    {     
      temp=x;  
      x=y;  
      y=temp;  
    }  
    switch(symbol)  
    {  
      case 0:  
        ans=x+y;  
        cout<<x<<'+'<<y<<'=';  
        break;  
      case 1:  
        ans=x-y;  
        cout<<x<< '-'<<y<<'=';  
        break;  
    }  
    cin>>n;  
    if(n==ans) 
    {
      sum+=10; 
      cout<<"    ¶Ô! "<<endl;   	 
    }
    else  
      cout<<"    ´í! "<<endl;  
  }  
  cout<<"µÃ·Ö£º"<<sum<<endl;  
  return 0;  
}  

