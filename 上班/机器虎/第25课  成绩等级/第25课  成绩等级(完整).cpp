#include <iostream>
using namespace std;
int main()
{
  int n;
  char score;
  cout<<"请输入分数：";
  cin>>n;
  switch(n/10)   //n、10是整型，n/10也是整型 
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
    default:  score=' ';break; //一个空格赋值给score 
  }
  cout<<score;
  return  0;
}

