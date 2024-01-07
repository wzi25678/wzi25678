#include <iostream>
using namespace std;
int main()
{
  for (int i = 1; i < 3000000; i++){
    if(i % 2 == 0){
        cout<<"叮叮"<<endl;
    }
     if(i % 3 == 0){
        cout<<"当当"<<endl;
    }
    if(i % 2 == 0 && i % 3 == 0){
      cout<<"叮叮当当"<<endl;
    }
  }
  cin.get();
  return  0;
}


