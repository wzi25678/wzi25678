#include <iostream>
using namespace std;
int main(){
	float km;
	cin>>km;
	if(km<=2){	//if�����ô�� 
		cout<<"����Ҫ֧��6Ԫ�򳵷ѡ�"<<endl;
	}else if(km>2 && km<=10){
		float money = 6 + (km-2)*1.8; 
		cout<<"����Ҫ֧��"<<money<<"Ԫ�򳵷ѡ�"<<endl;
	}else{	//else����   km>10 
		float money = 6 + 1.8 * 8 + (km-10)*2.7; 
		cout<<"����Ҫ֧��"<<money<<"Ԫ�򳵷ѡ�"<<endl;
	}
	cin.get();
	return 0;
} 
