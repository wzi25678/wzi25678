#include <iostream>
using namespace std;
int main()
{
  float height,weight,bmi;
  cout<<"����(��)��";
  cin>>height;
  cout<<"����(����)��";
  cin>>weight;
  bmi=weight/(height*height);
  if(bmi<18.5) 
     cout<<"ƫ��";
  else if(bmi<24)
          cout<<"����";
       else if(bmi<28)
               cout<<"ƫ��";
            else if(bmi<40)
			        cout<<"����";
			      else
				     cout<<"���ضȷ���";
   return 0;
}

