#include <iostream>
#include <ctime>      //��Ҫ����time()���� 
#include <cstdlib>    //��Ҫ����srand()��rand()����
using namespace std;
int main()
{
  int n,a;
  cout<<"�齱����"<<endl;
  int t = 1; 
  while(1==1){
  		srand(time(0));  //�������
  		a=rand()%2+1;  //�������1��100������
  		cout<<"������1-2:"<<endl;
  	 	cin>>n;
  	 	if(n>=1 && n<=2){
			if(n==a){
			  	cout<<"��ϲ�����н��ˣ�"<<endl;
			  	cout<<"����������"<<t<<"�β��С�" <<endl;
			  	t++;
			}
			else{
			  	cout<<"���ź�û�в��У�"<<endl;
			  	break;
			}
  		}else{
  			cout<<"�������������" <<endl;
		}
	} 
	cin.get();
  	return  0;
} 

