#include <iostream>
using namespace std;
int main()
{
  bool l=false;  
  l=!l;  // ��һ�¿���
  l=!l;  // !true��ֵΪfalse 
  l=!l;  // !false��ֵΪtrue 
  l=!l;  
  l=!l;  
  if(l) 
    cout<<"����";
  else
    cout<<"����";
  return  0; 
}

