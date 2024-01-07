#include <iostream>
using namespace std;
int main()
{
  int n;
  cout<<"请输入一个成绩:"<<endl;
  cin>>n;
  char score;
  if (n>=90){
    cout<<"你的成绩是A"<<endl;
  }else if(n>=70){
    cout<<"你的成绩是B"<<endl;
  }else if(n>=60){
    cout<<"你的成绩是C"<<endl;
  }else{
    cout<<"你的成绩是D"<<endl;
  }
  return 0;
}


