#include <iostream>
#include <cstdlib>
#include <string>
#include <cstring>
#include <stdio.h>
#include<algorithm>
using namespace std;
//typedef struct stack{  //链栈  内存超限
//    int data;
//    struct stack *next;
//};
//int sum=0;
//void Init_stack(stack *&s){
//    s->next=NULL;
//}
//void push(stack *&s,int n){//头插法
//    stack *s1;
//    s1=new stack;
//    s1->data=n;
//    s1->next=s;
//    s=s1;
//    sum++;
//}
//bool empty(stack *&s){
//    if(sum==0){
//        return true;
//    }else{
//        return false;
//    }
//}
//int top(stack *&s){
//    return s->data;
//}
//int pop(stack *&s){
//    stack *s1=s;
//    int p=s1->data;
//    s=s->next;
//    delete s1;
//    sum--;
//    return p;
//}
//顺序栈 时间超限
//typedef struct stack{
//    int data[100];
//    int top;
//    int base;
//};
//void Init_stack(stack *&s){
//    s->top=0;
//    s->base=0;
//}
//void push(stack *&s,int m){
//    s->data[++s->top]=m;
//}
//int top(stack *&s){
//    return s->data[s->top];
//}
//int pop(stack *&s){
//    return s->data[s->top--];
//}
//bool empty(stack *&s){
//    if(s->top==s->base){
//        return true;
//    }else{
//        return false;
//    }
//}
int main(){
    //解法一：但是测试过不去，使用itoa函数
//    char a[100];
//    int b;
//    cin>>b;
//    itoa(b,a,16);
//    int len=strlen(a);
//    a[len-1]=a[len-1]-32;
//    cout<<a;
    //解法二，分别使用顺序栈和链栈，都不行，顺序栈是时间超限，链栈是内存超限
//    int n;
//    stack *s=new stack;
//    Init_stack(s);
//    cin>>n;
//    while(1){
//        if(n==1){
//            break;
//        }
//        int m=n%16;
//        n=n/16;
//        push(s,m);
//    }
//    push(s,n);
//    while(!empty(s)){
//        switch(top(s)){
//        case 10: cout<<"A";break;
//        case 11: cout<<"B";break;
//        case 12: cout<<"C";break;
//        case 13: cout<<"D";break;
//        case 14: cout<<"E";break;
//        case 15: cout<<"F";break;
//        case 16: cout<<"G";break;
//        default: cout<<top(s);break;
//        }
//        pop(s);
//    }
    //解法三
    int a;
    cin>>a;
    if(a==0) {
        cout<<'0'<<endl; return 0;
    }
    string aaa="0123456789ABCDEF";
    string t="";
    int m;
    while(a>0){
        m=a%16;
        t+=aaa[m];
        a=a/16;
    }
    for(int j=t.length();j>0;j--) cout<<t[j-1];
    cout<<endl;
    return 0;
}
