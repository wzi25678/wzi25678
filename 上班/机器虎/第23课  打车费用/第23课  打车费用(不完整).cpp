#include <iostream>
using namespace std;
int main()
{
  float lucheng;
  float feiyong=0; 
  cin>>lucheng;
  if(lucheng <= 2){
  	cout<<"你需要支付6元打车费。"<<endl;
  }else if(lucheng > 2 && lucheng <=10){
  	float remind = lucheng-2;
  	float money;
  	money = 6 + remind*1.8;
  	cout<<"你需要支付"<<money<<"元打车费。"<<endl;
  } else{
  	float remind = lucheng-10;
	float money;
  	money = 6 + 8*1.8 + remind * 2.7; 
	cout<<"你需要支付"<<money<<"元打车费。"<<endl; 	
  }
  cin.get();
  return 0;
}

