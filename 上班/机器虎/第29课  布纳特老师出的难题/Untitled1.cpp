#include <iostream>
#include <limits>
using namespace std;
int main(){
	//ֱ����һ�Ƚ�
	int n;
	cin>>n;
	int max = numeric_limits<int>::min();
	for(int i=1;i<=n;i++){
		int a;+
		cin>>a;
		if(a > max){
			max = a;
		}
	}
	cout<<"�����Ϊ��"<<max<<endl; 
	cin.get();
	return 0;
}



