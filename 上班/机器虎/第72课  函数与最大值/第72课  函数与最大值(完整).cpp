#include <iostream>
using namespace std;
int ans,a[5];      //ȫ�ֱ�������λ�ú���ĺ���������ʹ����
int max(int x,int y)
{
  if(x>y) return x;
  else return y;
}
void fun1(void)
{
  int i;
  for(i=0;i<5;i++)
    cin>>a[i];
  ans=a[0];
  for(i=1;i<5;i++)
    ans=max(ans,a[i]);
}
int main()
{
  fun1();
  cout<<ans<<endl;
  return 0;
}


