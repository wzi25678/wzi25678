#include <iostream>
using namespace std;
int main()
{
  int n;
  cout<<"请输入1分钟跳绳次数：";
  cin>>n;
  if (n>=200 && n<=400) 
    cout<<"跳绳达人!";
  else if(n>400){
  	cout<<"jump god";
  }else if(n>=100){
  	cout<<"继续努力！";
  }else{
  	cout<<"回家洗洗睡吧。";
  }      
  return 0;
}

