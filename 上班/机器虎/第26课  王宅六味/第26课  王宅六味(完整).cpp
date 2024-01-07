#include <iostream>
using namespace std;
int main()
{
  int n;
  cout<<"ÇëÊäÈë±àºÅ£º";
  cin>>n;
  switch(n)
  {
    case 1: cout<<"ÊÙÏÉ¹½"<<endl;break;
    case 2: cout<<"¾ÆÔãÓó"<<endl;break;
    case 3: cout<<"ÏÂÉ½Ëñ"<<endl;break;
    case 4: cout<<"Ì«Ê¦¶¹¸¯"<<endl;break;	
    case 5: cout<<"Ð¢×ÓÓã"<<endl;break;	
    case 6: cout<<"ÖíÈ«¸£"<<endl;break;	
    default: cout<<"ÎÞ´Ë±àºÅµÄ²Ë"<<endl; break;	
  }
  return 0;
}

