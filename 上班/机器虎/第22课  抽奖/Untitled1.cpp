#include <iostream>
#include <ctime>      //需要调用time()函数 
#include <cstdlib>    //需要调用srand()和rand()函数
using namespace std;
int main()
{
  int n,a;
  cout<<"抽奖程序"<<endl;
  int t = 1; 
  while(1==1){
  		srand(time(0));  //随机种子
  		a=rand()%2+1;  //随机产生1至100的整数
  		cout<<"请输入1-2:"<<endl;
  	 	cin>>n;
  	 	if(n>=1 && n<=2){
			if(n==a){
			  	cout<<"恭喜您，中奖了！"<<endl;
			  	cout<<"这是连续第"<<t<<"次猜中。" <<endl;
			  	t++;
			}
			else{
			  	cout<<"很遗憾没有猜中！"<<endl;
			  	break;
			}
  		}else{
  			cout<<"输入的数不合理" <<endl;
		}
	} 
	cin.get();
  	return  0;
} 

