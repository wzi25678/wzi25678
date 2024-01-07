#include <iostream>
using namespace std;
int main()
{
  int  USER=54188,PSW=007,user,psw;
  cout<<"用户名:";
  cin>>user;
  cout<<"密码：";
  cin>>psw;
  if (user==USER)  
    if(psw==PSW)
      cout<<"亲爱的主人欢迎您!";
    else
      cout<<"密码错误!";
  else
    cout<<"用户名不正确!" ;  
  return 0;
}

