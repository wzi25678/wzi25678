#include <iostream>      
using namespace std;   
int main()
{ 
  int i;
  char xiaotou;
  for(i=1;i<=4;i++)
    if((i!=1)+(i==3)+(i==4)+(i!=4)==3)
    {
      xiaotou=64+i;
      cout<<"Ð¡ÍµÊÇ£º"<<xiaotou;
      break;
    }
  return 0; 
}

