#include <iostream>
using namespace std;
int main()
{

  for(int i=2147480000;i<=99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999;i++){	//int i = 1   类型int   
  /*
  一个二进制就是一个位
  八个位就是一个字节
  
  int 四个字节   32位   2^32
  2^3 /2   
  最小 -2^31          最大 2^31 - 1
   -2147483648			2147483647	
  */ 
    cout<<"爱你三千遍！ 	这是第"<<i<<"遍。"<<endl;
  }
  cout<<"少儿不宜！！！"<<endl; 
  //for()循环
  cin.get();  
  return  0;
}


