#include <iostream>
#include <cstdio> //����gets()��puts()���� 
using namespace std; 
int main()
{
   char str[2000]; 
   int i,num,numa;
   num=numa=0;
   gets(str);
   for(i=0;str[i]!='\0';i++)
   {  
    num++;  
    if(str[i]=='.')
      numa++;
   }
   puts(str);
   cout<<"�ַ����� ��"<<num<<endl;
   cout<<".�ĸ�����"<<numa<<endl;  
   return 0;
}

