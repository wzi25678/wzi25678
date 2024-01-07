#include <iostream>
using namespace std;
int main()
{
	//输入一个四位数，1234
	//			2341    百十个千
	int n;
	cin>>n;
	int qian = n/1000;
	int qianyu = n%1000;
	int bai = qianyu/100;//dsdjfbejfbuhguiuih yfdm,jn  jmn mjhu ulo9ite hikdfuikfskfi m   kdvujvidf8g78r8eh   jvhdm]iooytb ???????????????? 
	int baiyu = qianyu%100;
	int shi = baiyu/10;
	int ge = baiyu%10;
	cout<<bai<<shi<<ge<<qian;
  	return 0;
}

