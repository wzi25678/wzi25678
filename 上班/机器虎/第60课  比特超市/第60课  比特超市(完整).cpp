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
	cout<<"��ǰ�˿�Ӧ���Ļ���:" ;
    cout <<sumone<<endl;
	if(sumone!=0) num++;
	sum+=sumone;
  }
  cout<<"�����Ӫҵ�"<<sum<<endl;
  cout<<"����Ĺ˿�������"<<num<<endl;
  return 0;
}

