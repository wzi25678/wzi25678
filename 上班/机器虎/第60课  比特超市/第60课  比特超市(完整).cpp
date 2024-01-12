#include <iostream>
using namespace std;
int main()
{
  int num=0;
  float n,sumone,sum;
  bool  flag; 
  flag=true;
  sum=0.0;
  while(flag)
  { 
    sumone=0.0;
  	do
  	{
      cin>>n; 
	  if(n==-1)
	  {
	  	flag=false;
	  	break;
	  }
  	  sumone+=n;
	}while(n!=0);
	cout<<"当前顾客应付的货款:" ;
    cout <<sumone<<endl;
	if(sumone!=0) num++;
	sum+=sumone;
  }
  cout<<"今天的营业额："<<sum<<endl;
  cout<<"今天的顾客人数："<<num<<endl;
  return 0;
}

