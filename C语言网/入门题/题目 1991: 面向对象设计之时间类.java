#include<bits/stdc++.h>
using namespace std;
class Time
{
    private:
        int h;
        int m;
        int s;
    public:
        int set(int s)
        {
            this->h=s/3600;
            this->m=(s-this->h*3600)/60;
            this->s=s%60; 
            return 0;
        }
        int display()
        {
            cout<<this->h<<":"<<this->m<<":"<<this->s<<endl; 
            return 0;
        }
};
int main()
{
    class Time time;
    int n;
    cin>>n;
    time.set(n);
    time.display();
    return 0;
}
