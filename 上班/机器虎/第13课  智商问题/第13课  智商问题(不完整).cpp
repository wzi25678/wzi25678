#include <iostream>
using namespace std;
int main()
{
  cout<<"IQ:"; 
  /*
  一、if -else if  -else
  二、switch...case 
  */ 
  int iq;
  cin>>iq;              
  if(iq>=200){
  	cout<<"genius！";
  }else if(iq >140){
  	cout<<"清华北大苗子";
  }else if(iq >100){
  	cout<<"泉州五中稳了！";
  }else if(iq>50){
  	cout<<"继续努力。";
  }else{
  	cout<<"回家洗洗，赶紧睡。";
  }         
  //天才   
  return 0;
}


