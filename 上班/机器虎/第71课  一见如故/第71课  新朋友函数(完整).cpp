#include <iostream>
using namespace std;
void show(int geshu)
{
  int i;
  for(i=1;i<=geshu;i++)
    cout<<"*";
  cout<<endl;
}
int main()
{
  int i, n;     
  cout<<"ÐÐÊý£º";
  cin>>n; 
  for(i=1;i<=n;i++)
    show(i);
  return 0;
}

