#include <iostream>
using namespace std;
int main()
{
	int user,password;
	int userArray [100], passwordArray[100];
	int userArrayIndex = 0,passwordArrayIndex = 0;
	while(1==1){
		cout<<endl;
		cout<<endl;
		cout<<endl;
		cout<<"-----------------------------------------"<<endl;
		cout<<"∞Æ∆Ê“’ª∂”≠ƒ˙£°"<<endl;
		int options;
		cout<<" ‰»Î1±Ì æµ«¬º£¨ ‰»Î2±Ì æ◊¢≤·£¨∆‰À˚±Ì æ∞⁄¿√°£"<<endl;
		cin>>options;
		if(options == 1){
			//µ«¬º
			//œ»≈–∂œ’À∫≈
			cout<<"«Î ‰»Î’À∫≈£∫"<<endl;
			cin>>user;
			cout<<"«Î ‰»Î√‹¬Î£∫"<<endl;
			cin>>password;
			for(int i = 0;i<100;i++){
				if(userArray[i] == user && passwordArray[i] == password){
					// ‰»Îµƒ’À∫≈∂‘¡À°£
					cout<<"ª∂”≠µ«¬º£¨ø…“‘ø™ ºø¥µÁ ”æÁ°£"<<endl;
					return 0;
				}else{
					cout<<"ƒ˙ ‰»Îµƒ’À∫≈ªÚ’ﬂ√‹¬Î¥ÌŒÛ°£"<<endl;
					break; 
				}
			}
		}else if(options == 2){
			//◊¢≤·
			cout<<"ª∂”≠◊¢≤·∞Æ∆Ê“’°£"<<endl;
			cout<<"«Î ‰»Î◊¢≤·’À∫≈£∫"<<endl;
			cin>>userArray[userArrayIndex];
			++userArrayIndex;
			cout<<"«Î ‰»Î◊¢≤·√‹¬Î£∫"<<endl;
			cin>>passwordArray[passwordArrayIndex];
			++passwordArrayIndex;
		}else{
			return 0;
		}
	}
  	return 0;
}


