#include <iostream>
using namespace std;
int main()
{
  float height,weight,bmi;
  cout<<"身体(米)：";
  cin>>height;
  cout<<"体重(公斤)：";
  cin>>weight;
  bmi=weight/(height*height);
  if(bmi<18.5) 
     cout<<"偏瘦";
  else if(bmi<24)
          cout<<"正常";
       else if(bmi<28)
               cout<<"偏胖";
            else if(bmi<40)
			        cout<<"肥胖";
			      else
				     cout<<"极重度肥胖";
   return 0;
}

