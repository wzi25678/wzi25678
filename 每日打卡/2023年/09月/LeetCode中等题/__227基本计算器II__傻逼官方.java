package LeetCode中等题;

import java.util.ArrayDeque;
import java.util.Deque;

public class __227基本计算器II__傻逼官方 {
    //给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
    public int calculate(String s) {
        /*  解题思路：
        1.肯定得用栈来实现，然后呢？
        2.因为【乘法，除法】优先级更高，因此我们第一次操作时，只针对【乘法，除法】进行出栈计算操作，并把值返回栈中
        3.第二次，再进行【加法，减法】的计算操作
         */
        Deque <Integer> stack = new ArrayDeque<>();
        int n = s.length();
        int num = 0;
        for (int i=0;i<n;i++){
            if (Character.isDigit(s.charAt(i))){
                //在Java中，Character.isDigit(char ch)函数用于判断给定的字符是否是一个数字字符。它是Character类的一个静态方法。
                num = num *10 +s.charAt(i) - '0';
            }
            char preSign = 0;
            if (!Character.isLetter(s.charAt(i)) && s.charAt(i) != ' ' || i == n-1 ){
                switch (preSign){
                    case '+':

                }

            }
        }
        return 0;

    }
    //1 <= s.length <= 3 * 105
    //('+', '-', '*', '/')
}
