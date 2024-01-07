#include <iostream>
using namespace std;
int main()
{
	int a = 12345; 
	int wan,qian,bai,shi,ge;
	//789  n     n/100    n%100    百以内的余数			89
	//89  - -- - - - - - - - -- - - - - -- - 
	//89/10     89%10       
	//      /    %   
	wan = (a/10000);//1
	int wan_yu = a%10000;	//2345
	qian = wan_yu /1000; 	//2
	int qian_yu  = wan_yu %1000;	//345
	bai =  qian_yu /100;  //头    %10  尾 
	int bai_yu = qian_yu %100; //45
	shi = bai_yu /10;
	ge = bai_yu %10; 
	cout<<"万:"<<wan<<endl; 
	cout<<"千:"<<qian<<endl;
	cout<<"百:"<<bai<<endl;
	cout<<"十:"<<shi<<endl;
	cout<<"个:"<<ge<<endl;
	return 0;	
 }


