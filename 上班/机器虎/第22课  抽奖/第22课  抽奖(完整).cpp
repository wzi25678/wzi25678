#include <iostream>
#include <ctime>      //需要调用time()函数 
#include <cstdlib>    //需要调用srand()和rand()函数
using namespace std;
int main()
{
  int n,a;
  cout<<"抽奖程序"<<endl;
  srand(time(0));  //随机种子
  a=rand()%10+1;  //随机产生1至100的整数
  int arr[100] = {0};
  int t = 1; 
  while(1==1){
  		cout<<"请输入1-10:"<<endl;
  	 	cin>>n;
  	 	if(n>=1 && n<=10){
  	 		if(arr[n-1] != 0){
  	 			cout<<"这个数你输入过。请重新输入。"<<endl;
  	 			continue;
			}
  	 		arr[n-1] = n;
			if(n==a){
			  	cout<<"恭喜您，中奖了！"<<endl;
			}
			else{
			  	cout<<"没中奖，这是第"<<t<<"次抽。" <<endl;
			  	t++;
			}
  		}else{
  			cout<<"输入的数不合理" <<endl;
		}
	} 
  return  0;
} 

