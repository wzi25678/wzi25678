#include <iostream>
using namespace std;
int main()
{
  int n;
  char score;
  cout<<"�����������";
  cin>>n;
  switch(n/10)   //n��10�����ͣ�n/10Ҳ������ 
  {
    case 10:
    case 9:   score='A';break;
    case 8:
    case 7:   score='B';break;
    case 6:   score='C';break;
    case 5:
    case 4:
    case 3:
    case 2:
    case 1:
    case 0:   score='D';break;
    default:  score=' ';break; //һ���ո�ֵ��score 
  }
  cout<<score;
  return  0;
}

