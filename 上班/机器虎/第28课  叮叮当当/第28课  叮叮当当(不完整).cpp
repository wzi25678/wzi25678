#include <iostream>
using namespace std;
int main()
{
  for (int i = 1; i <= 3000; i++){
      if (i %2 == 0 && i %3==0){
          cout<<"格莱尔："<<"叮叮铛铛。"<<endl;
          //continue; //继续
      }else if(i %2 == 0){
          cout<<"格莱尔："<<"叮叮^_^"<<endl;
      }else if (i %3==0){
          cout<<"格莱尔："<<"铛铛= =~"<<endl;
      }
  }
  cin.get();
  return 0;
}

