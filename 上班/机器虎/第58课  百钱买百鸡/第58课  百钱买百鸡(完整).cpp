#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
  int gongji,muji,xiaoji;
  cout<<setw(5)<<"¹«¼¦"<<setw(5)<<"Ä¸¼¦"<<setw(5)<<"Ð¡¼¦"<<endl;
  for(gongji=1;gongji<=33;gongji++)
    for(muji=1;muji<=50;muji++)
    {
      xiaoji=100-gongji-muji;
      if(gongji*3+muji*2+xiaoji/3.0==100)
	    cout<<setw(5)<<gongji<<setw(5)<<muji<<setw(5)<<xiaoji<<endl;
	}
  return 0;
}

