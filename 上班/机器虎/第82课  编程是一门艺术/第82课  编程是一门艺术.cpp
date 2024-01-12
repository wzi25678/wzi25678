#include <iostream>
using namespace std;
class artist   //用class来声明类，类名为artist
{
  private:    //声明私有的数据和成员函数
    string name; //只能在本类中的成员函数引用，类外不能调用
    int age;
  public: //声明公有的数据和成员函数，本类和类外都能调用
    void set(string studname,int studage)
   	{
      name=studname;
      age=studage;	
    }
    void display()  //成员函数
    {
      cout<<"编程是一门艺术"<<endl;	
      cout<<"小艺术家的姓名："<<name<<endl;
      cout<<"小艺术家的年龄:"<<age<<endl;
      cout<<"---------------"<<endl;
	}
};   //注意，这里有分号
int main()
{
  artist  stud1,stud2; //定义了artist类的两个对象stud1,stud2
  stud1.set("nike",11);
  stud1.display();
  stud2.set("glair",12);
  stud2.display();
  return 0;  
}

