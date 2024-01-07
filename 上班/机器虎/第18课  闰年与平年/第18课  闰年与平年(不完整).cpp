#include <iostream>
using namespace std;
int main()
{
  int year;
  cout<<"请输入一个年份：";
  cin>>year;
 //闰年？366    2   29  
  //逻辑判断      门电路   
 //与（同时满足）     &&	至少要两个条件以上 
 //	或 （满足其中一个就行）    ||     至少要两个条件以上 
 //	非（取当前情况的相反） 	   !     一个条件
 //ctrl   control控制
 //shift   换挡
 //Caps Lock  帽子 锁
 //tab   
  
//满足两者之一就是闰年
 //条件1：   能把4整除并且不能把100整除
 //条件2：    能把400整除 
  return 0;
} 


