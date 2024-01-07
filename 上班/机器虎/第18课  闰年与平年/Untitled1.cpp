#include <iostream>   
using namespace std;
int main()
{
  int year;
  cout<<"请输入一个年份：";//   ' '     " "
  cin>>year;
 //满足两者之一就是闰年      ##  '''  	'''     """	 	"""
 //条件1：   能把4整除并且不能把100整除
 //条件2：   能把400整除 
 if((year % 4 ==0 && year % 100 !=0	)||(year % 400 ==0	)){
 	cout<<"This is Run year."<<endl;
 	return 0;
 }
 cout<<"This is Ping year."<<endl;
  //与（同时满足）     &&	至少要两个条件以上 
 //	或 （满足其中一个就行）    ||     至少要两个条件以上 
 //	非（取当前情况的相反） 	   !     一个条件
  return 0;
} 


