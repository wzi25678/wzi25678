#include <iostream>
using namespace std;
int main()
{
  for (int i = 1; i <= 3000; i++){
  	     cout<<"������ʦ��"<<i<<endl; 
      if (i %2 == 0 && i %3==0){
          cout<<"��������"<<"����������"<<endl;
          //continue; //����
      }else if(i %2 == 0){
          cout<<"��������"<<"����^_^"<<endl;
      }else if (i %3==0){
          cout<<"��������"<<"����= =~"<<endl;
      }
  }
  cin.get();
  return 0;
}


