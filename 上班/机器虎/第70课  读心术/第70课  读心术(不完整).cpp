#include <iostream>
#include <string>
#include <cstdlib>   //调用system()函数 
using namespace std;
int main()
{
  int i,a[4],ans;
  string t[4];
  t[0]="1,2,3,4,5,6,7";
  t[1]="1,3,5,7";
  t[2]="2,3,6,7";
  t[3]="4,5,6,7";
  cout<<"读心术猜数"<<endl; 
  cout<<"请你在下面7个数中，选一个并记在心里。"<<endl; 
  cout<<t[0]<<endl;
  system("pause");    //暂停 


  system("cls");
  cout<<"你心中想的数是:" ;
  cout<<ans<<endl;  
  return 0;
}

