#include <iostream>
#include <ctime>      //��Ҫ����time()���� 
#include <cstdlib>    //��Ҫ����srand()��rand()����
using namespace std;
int main()
{
  int n,a;
  cout<<"�齱����"<<endl;
  srand(time(0));  //�������
  a=rand()%10+1;  //�������1��100������
  int arr[100] = {0};
  int t = 1; 
  while(1==1){
  		cout<<"������1-10:"<<endl;
  	 	cin>>n;
  	 	if(n>=1 && n<=10){
  	 		if(arr[n-1] != 0){
  	 			cout<<"�����������������������롣"<<endl;
  	 			continue;
			}
  	 		arr[n-1] = n;
			if(n==a){
			  	cout<<"��ϲ�����н��ˣ�"<<endl;
			}
			else{
			  	cout<<"û�н������ǵ�"<<t<<"�γ顣" <<endl;
			  	t++;
			}
  		}else{
  			cout<<"�������������" <<endl;
		}
	} 
  return  0;
} 

