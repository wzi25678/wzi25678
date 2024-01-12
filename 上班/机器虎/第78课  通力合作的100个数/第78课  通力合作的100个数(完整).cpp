#include <iostream>
#include <iomanip>
using namespace std;
void show(int n); 
int main()
{
  int n=100;
  show(n);
  return 0;
}
void show(int n)
{
  if(n!=1) show(n-1);	
    cout<<setw(5)<<n;  
}

