#include <iostream>
using namespace std;
int search(int b[],int len,int key)
{
  int high,low;
  high=len-1;
  low=0;
  int mid=len/2;
  while(high>=low)
  {
    mid=(high+low)/2;
    cout<<b[mid]<<endl;
    if(b[mid]==key)
      return mid;
    else if(b[mid]>key)
           high=mid-1;         
         else 
           low=mid+1;
  }
  return 0;
}
main()
{
  const int max=100;
  int a[max],n;
  for(int i=0;i<max;i++)
    a[i]=i+1;
  do
  {
    cin>>n;	
  }while(n<1||n>100);
  if(search(a,max,n)) 
    cout<<"³É¹¦£¡";
  else
    cout<<"Ê§°Ü£¡";
  return 0; 
}

