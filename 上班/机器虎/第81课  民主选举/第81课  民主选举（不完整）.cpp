#include <iostream>
using namespace std;
const int MAX=5;      //候选人的人数
int count(int b[],int n)
{
  int x;
  for(int i=1;i<=n;i++)
  {
    do 
    {
      cout<<i<<':';
      cin>>x;
    }while(x<0||x>MAX);
    b[x]++;
  }
}
int main()
{  
  int a[MAX+1],i,n ,*p;  //a[0]统计弃权的票数
  cout<<"请输入实到人数：";
  cin>>n;



 
  p=a; //指针变量p重新指向数组首元素
  count(p,n);
  for(i=0;i<=MAX;i++)
  {
    switch(i)
    {
      case 0:cout<<"弃权:"<<a[i]<<endl;break;
      default:cout<<i<<"号票数:"<<a[i]<<endl;break;
    }
  }
  return 0;
}

