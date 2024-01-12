#include <iostream>
using namespace std;
int main()
{
  int make,boli,mani,nike;
  bool tj[4];
  for(make=1;make<=4;make++)
    for(boli=1;boli<=4;boli++)
      for(mani=1;mani<=4;mani++)
      {
        nike=10-make-boli-mani;
        if(make*boli*mani*nike==1*2*3*4)
        {
	      tj[0]=((make==1)+(boli==4)+(mani==3)+(nike==2)==2);
	      tj[1]=((boli==1)+(make==4)+(mani==2)+(nike==3)==2);
          tj[2]=((boli==4)+(make==3)==1);
	      tj[3]=((make==1)+(nike==4)+(boli==3)+(mani==2)==2);
          if(tj[0]&&tj[1]&&tj[2]&&tj[3])
	      {
            cout<<"马克："<<make<<endl;
            cout<<"波力："<<boli<<endl;
            cout<<"马尼："<<mani<<endl;
            cout<<"尼克："<<nike<<endl;
            break;	 
		  }	   	
	    }
      }
  return 0;
}

