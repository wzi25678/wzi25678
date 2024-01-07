#include <iostream>
using namespace std;
int main(){
	float km;
	cin>>km;
	if(km<=2){	//if如果怎么样 
		cout<<"你需要支付6元打车费。"<<endl;
	}else if(km>2 && km<=10){
		float money = 6 + (km-2)*1.8; 
		cout<<"你需要支付"<<money<<"元打车费。"<<endl;
	}else{	//else否则   km>10 
		float money = 6 + 1.8 * 8 + (km-10)*2.7; 
		cout<<"你需要支付"<<money<<"元打车费。"<<endl;
	}
	cin.get();
	return 0;
} 
