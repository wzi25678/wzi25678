#include <iostream>
#include <ctime>      //需要调用time()函数 
#include <cstdlib>    //需要调用srand()和rand()函数
using namespace std;	//std：standard 标准 
int main()
{
  int n,a;   
  int arr[50]={0};
  cout<<"抽奖程序"<<endl;
  srand(time(0));  //随机种子
  a=rand()%50+1;  //随机产生1至100的整数
  int t = 0;
  while(1==1){
  	int n;
  	cout<<"请输入1-50:"<<endl;
  	cin>>n;	//民国四大帅哥：徐志摩，周恩来，张学良
  	//秦  ---商鞅（变法）
  	//     --卫     --诸侯，  商 
  	//      秦惠王   --100  --216 
  	//   封建帝制--26代 
	/*
	百家争鸣		--春秋战国
					//战国七雄 --秦  魏（庞统，孙膑） 
	//兵，儒，道，法 	--孔子，孟子，荀子 
	//    仁爱    兼爱，非攻
	//韩非！
	//春秋战国，秦，汉（项羽，刘邦），后汉，三国争霸，（司马懿）
	//晋，五胡入华，隋（京杭大运河）, 唐618,宋，元，明，清
	//近现代屈辱史
	//邓世昌，李鸿章 
	
	 
					 
	
	*/   
  	if(n>=1 && n<=50){
  		if(arr[n-1] != 0){
  			cout<<"当前数字你已经抽过。"<<endl;
  			continue;
		}else{
			if(n==a){
	  			cout<<"恭喜您，中奖了！"<<endl;
	  			break;
			}else{
				t++;
				cout<<"没中奖，这是第"<<t<<"次抽。" <<endl;
			} 
		} 
  		
	}else{
		cout<<"输入的数不合理." <<endl;	
	}
  } 
  cin.get();
  return  0;
} 

