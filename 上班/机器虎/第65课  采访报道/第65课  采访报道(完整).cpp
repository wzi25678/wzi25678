#include <iostream>
#include <cstdio> //调用gets()和puts()函数 
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
   cout<<"字符个数 ："<<num<<endl;
   cout<<".的个数："<<numa<<endl;  
   return 0;
}

