#include <iostream>
using namespace std;
int main()
{
	int user,password;
	int userArray [100], passwordArray[100];
	int userArrayIndex = 0,passwordArrayIndex = 0;
	while(1==1){
		cout<<endl;
		cout<<endl;
		cout<<endl;
		cout<<"-----------------------------------------"<<endl;
		cout<<"�����ջ�ӭ����"<<endl;
		int options;
		cout<<"����1��ʾ��¼������2��ʾע�ᣬ������ʾ���á�"<<endl;
		cin>>options;
		if(options == 1){
			//��¼
			//���ж��˺�
			cout<<"�������˺ţ�"<<endl;
			cin>>user;
			cout<<"���������룺"<<endl;
			cin>>password;
			for(int i = 0;i<100;i++){
				if(userArray[i] == user && passwordArray[i] == password){
					//������˺Ŷ��ˡ�
					cout<<"��ӭ��¼�����Կ�ʼ�����Ӿ硣"<<endl;
					return 0;
				}else{
					cout<<"��������˺Ż����������"<<endl;
					break; 
				}
			}
		}else if(options == 2){
			//ע��
			cout<<"��ӭע�ᰮ���ա�"<<endl;
			cout<<"������ע���˺ţ�"<<endl;
			cin>>userArray[userArrayIndex];
			++userArrayIndex;
			cout<<"������ע�����룺"<<endl;
			cin>>passwordArray[passwordArrayIndex];
			++passwordArrayIndex;
		}else{
			return 0;
		}
	}
  	return 0;
}


