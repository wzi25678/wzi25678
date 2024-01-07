#include <iostream>
using namespace std;
int main()
{
  for (int i = 1; i <= 3000; i++){
  	     cout<<"ºüÀêÀÏÊ¦£º"<<i<<endl; 
      if (i %2 == 0 && i %3==0){
          cout<<"¸ñÀ³¶û£º"<<"¶£¶£îõîõ¡£"<<endl;
          //continue; //¼ÌÐø
      }else if(i %2 == 0){
          cout<<"¸ñÀ³¶û£º"<<"¶£¶£^_^"<<endl;
      }else if (i %3==0){
          cout<<"¸ñÀ³¶û£º"<<"îõîõ= =~"<<endl;
      }
  }
  cin.get();
  return 0;
}


