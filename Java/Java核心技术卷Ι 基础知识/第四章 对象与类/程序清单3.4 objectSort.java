import java.math.BigInteger;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
////////////////////////////////////////////////////////////////////
    //-----------------------------------------------------------------------
    class Person {
        private String lastName;
        private String firstName;
        private int age;

        //-----------------------------------------------------------------------
        public Person(String last, String first, int ag) {
            lastName = last;
            firstName = first;
            age = ag;
        }

        //-----------------------------------------------------------------------
        public void displayPerson() {
            System.out.print("Last name: " + lastName);
            System.out.print(" ,First name: " + firstName);
            System.out.println(" ,Age : " + age);
        }
        //-----------------------------------------------------------------------
        public String getLastName(){
            return lastName;
        }
    }//end class Person
////////////////////////////////////////////////////////////////////
    class ArrayInob{
        private Person[] a;
        private  int nElems;
    //-----------------------------------------------------------------------
        public ArrayInob(int max){
            a = new Person[max];    //构造器，创建初始化数组
            nElems = 0;
        }
    //-----------------------------------------------------------------------
        public void insert(String last,String first,int age){
            a[nElems] = new Person(last,first,age);
            nElems++;
        }
    //-----------------------------------------------------------------------
        public void display(){
          /*  for (Person i:a
                 ) {
                a[i].displayPerson();
            }*/
            for (int j=0;j<nElems;j++){
                a[j].displayPerson();
            }
            System.out.println("");
        }
    //-----------------------------------------------------------------------
        public void insertionSort(){
            int in,out;

            for (out=1;out<nElems;out++){
                Person temp = a[out];
                in = out;
                while (in>0 && a[in-1].getLastName().compareTo(temp.getLastName())>0){
                    a[in] = a[in-1];
                    --in;
                }
                a[in] = temp;
            }//end for
        }//end insertionSort()
    static class ObjectSortApp{
        public static void main(String[] args) {
           int maxSize = 100;
           ArrayInob arr;
           arr = new ArrayInob(maxSize);
           
           arr.insert("Evans","Patty",24);
           arr.insert("Smith","Doc",59);
           arr.insert("Smith","Lorraine",37);
           arr.insert("Smith","Paul",37);
           arr.insert("Yee","Tom",43);
           arr.insert("Hashimoto","Sato",21);
           arr.insert("Stimson","Henry",29);
            System.out.println("Before sorting:");
            arr.display();
            arr.insertionSort();
            System.out.println("After sorting:");
            arr.display();
        }
    }
}   //end calss ArratInob
////////////////////////////////////////////////////////////////////
