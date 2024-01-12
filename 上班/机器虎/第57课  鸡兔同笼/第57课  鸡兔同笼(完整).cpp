#include <iostream> 
using namespace std;
int main()
{
  int ji,tu;
  for(ji=1;ji<=34;ji++)
    for(tu=1;tu<=23;tu++)
    {
      if(ji+tu==35)
        if(ji*2+tu*4==94)
          cout<<"¼¦£º"<<ji<<"  ÍÃ£º"<<tu<<endl;
    }
  return 0;
}

