#include <iostream>   
using namespace std;
int main()
{
  int year;
  cout<<"������һ����ݣ�";//   ' '     " "
  cin>>year;
 //��������֮һ��������      ##  '''  	'''     """	 	"""
 //����1��   �ܰ�4�������Ҳ��ܰ�100����
 //����2��   �ܰ�400���� 
 if((year % 4 ==0 && year % 100 !=0	)||(year % 400 ==0	)){
 	cout<<"This is Run year."<<endl;
 	return 0;
 }
 cout<<"This is Ping year."<<endl;
  //�루ͬʱ���㣩     &&	����Ҫ������������ 
 //	�� ����������һ�����У�    ||     ����Ҫ������������ 
 //	�ǣ�ȡ��ǰ������෴�� 	   !     һ������
  return 0;
} 


