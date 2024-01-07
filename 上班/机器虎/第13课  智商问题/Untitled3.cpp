#include <iostream>
using namespace std;
int main()
{
	int user,password;
	cout<<"欢迎进入摩尔庄园。"<<endl;
	cin>>user;
	cin>>password;
	if(user == 201707){
		if(password == 135790){
			cout<<"可以打王者荣耀了！"<<endl;
		}else{
			cout<<"不知道密码就不要浪费时间。"<<endl; 
			return 0;
		} 
	}else{
		cout<<"赶紧回家，不要乱敲。"<<endl;
		return 0; 
	}
  	return 0;
}


