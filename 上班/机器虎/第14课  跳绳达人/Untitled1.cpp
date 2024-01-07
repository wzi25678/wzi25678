#include <iostream>
using namespace std;
int main()
{
  char a = '0';
  cout<<(int)a<<endl; 	//char   ->    int		//48
  a = '9';
  cout<<(int)a<<endl; 	//48+9 = 57
  //A ~ Z   ,	a ~ z
  a = 'A';	//65			//32
  cout<<(int)a<<endl; 
   a = 'Z';	//90
  cout<<(int)a<<endl; 
    a = 'a';
  cout<<(int)a<<endl;		//97 
   a = 'z';
  cout<<(int)a<<endl; 		//122
  return 0;
}

