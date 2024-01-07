#include <iostream>
using namespace std;	//standard
int main()	//int-> integer 
{
  char  n;	//character
  cout<<"ÊäÈëa~z:";	//input/output  
  /*
  ASCIIÂë£º
  	×Ö·ûÓĞ¸ö¶ÔÓ¦µÄ±àºÅ
	Êı×Ö×Ö·û   0-9    48-57
	space¿Õ¸ñ    32 
	Ó¢ÎÄ×ÖÄ¸	A-Z   65-90    a-z    97-122 
	97  65  32    	
	122 90  32
	ÌØÊâ·ûºÅ¡£¡£¡£¡£   
  */
  cin>>n;
  n=n-32;
  cout<<n<<endl;
  return 0;
}
