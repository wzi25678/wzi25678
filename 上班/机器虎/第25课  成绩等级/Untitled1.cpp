#include <iostream>
using namespace std;
int main()
{
  int n;
  cout<<"������һ���ɼ�:"<<endl;
  cin>>n;
  char score;
  if (n>=90){
    cout<<"��ĳɼ���A"<<endl;
  }else if(n>=70){
    cout<<"��ĳɼ���B"<<endl;
  }else if(n>=60){
    cout<<"��ĳɼ���C"<<endl;
  }else{
    cout<<"��ĳɼ���D"<<endl;
  }
  return 0;
}


