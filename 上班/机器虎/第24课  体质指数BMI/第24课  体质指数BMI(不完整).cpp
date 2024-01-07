#include <iostream>
using namespace std;
int main()
{
  float height,weight,bmi;
  cout<<"身高(米)：";
  cin>>height;
  cout<<"体重(kg)：";
  cin>>weight;
  bmi=weight/(height*height);
  cout<<"你的BMI是："<<bmi;
  return 0;
}

