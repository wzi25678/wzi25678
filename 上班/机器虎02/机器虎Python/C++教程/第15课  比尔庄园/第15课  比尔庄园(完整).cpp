#include <iostream>
using namespace std;
int main()
{
  int  USER=54188,PSW=007,user,psw;
  cout<<"�û���:";
  cin>>user;
  cout<<"���룺";
  cin>>psw;
  if (user==USER)  
    if(psw==PSW)
      cout<<"�װ������˻�ӭ��!";
    else
      cout<<"�������!";
  else
    cout<<"�û�������ȷ!" ;  
  return 0;
}

