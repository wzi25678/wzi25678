#include <iostream>
using namespace std;
int main()
{
  float height,weight,bmi;
  cout<<"���(��)��";
  cin>>height;
  cout<<"����(kg)��";
  cin>>weight;
  bmi=weight/(height*height);
  cout<<"���BMI�ǣ�"<<bmi;
  return 0;
}

