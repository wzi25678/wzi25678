#include <iostream>
using namespace std;
int main()
{
	int user,password;
	cout<<"��ӭ����Ħ��ׯ԰��"<<endl;
	cin>>user;
	cin>>password;
	if(user == 201707){
		if(password == 135790){
			cout<<"���Դ�������ҫ�ˣ�"<<endl;
		}else{
			cout<<"��֪������Ͳ�Ҫ�˷�ʱ�䡣"<<endl; 
			return 0;
		} 
	}else{
		cout<<"�Ͻ��ؼң���Ҫ���á�"<<endl;
		return 0; 
	}
  	return 0;
}


