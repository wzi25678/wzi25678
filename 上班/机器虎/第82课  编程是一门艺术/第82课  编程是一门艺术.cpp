#include <iostream>
using namespace std;
class artist   //��class�������࣬����Ϊartist
{
  private:    //����˽�е����ݺͳ�Ա����
    string name; //ֻ���ڱ����еĳ�Ա�������ã����ⲻ�ܵ���
    int age;
  public: //�������е����ݺͳ�Ա��������������ⶼ�ܵ���
    void set(string studname,int studage)
   	{
      name=studname;
      age=studage;	
    }
    void display()  //��Ա����
    {
      cout<<"�����һ������"<<endl;	
      cout<<"С�����ҵ�������"<<name<<endl;
      cout<<"С�����ҵ�����:"<<age<<endl;
      cout<<"---------------"<<endl;
	}
};   //ע�⣬�����зֺ�
int main()
{
  artist  stud1,stud2; //������artist�����������stud1,stud2
  stud1.set("nike",11);
  stud1.display();
  stud2.set("glair",12);
  stud2.display();
  return 0;  
}

