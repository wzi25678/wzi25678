#include <iostream>
using namespace std;
int main(){
	int n;
	cin>>n;
	int sum = 0;
	for(int i=1;i<=n;i++){
		sum+=i;
		cout<<"从1 加到"<<i<<"的和为：" <<sum<<endl; 
	}
	return 0;
} 

