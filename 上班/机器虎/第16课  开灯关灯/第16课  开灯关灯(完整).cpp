#include <iostream>
using namespace std;
int main()
{
  bool l=false;  
  l=!l;  // 拉一下开关
  l=!l;  // !true的值为false 
  l=!l;  // !false的值为true 
  l=!l;  
  l=!l;  
  if(l) 
    cout<<"灯亮";
  else
    cout<<"灯灭";
  return  0; 
}

