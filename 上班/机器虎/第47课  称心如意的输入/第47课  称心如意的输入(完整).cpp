#include <iostream>
using namespace std;
int main()
{
  float x; 
  do
  {
  	cout<<"������ɼ�(0~100):";
    cin>>x;
  }while(x<0||x>100);
  cout<<"�ɼ�:"<<x<<endl;
  return 0;
}

