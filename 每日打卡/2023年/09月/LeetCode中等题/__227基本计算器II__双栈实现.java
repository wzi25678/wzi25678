package LeetCode中等题;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class __227基本计算器II__双栈实现 {
    public int calculate(String s) {
        /**
        双栈实现：
             数字栈 -> numStack存储要操作的数字
             操作栈 -> opStack存储加减乘除取模操作符

         优先级考虑：
            由于存在操作优先级，因此用HashMap存储对应操作符的优先级
            1.遇到空格直接跳过
            2.遇到加减乘除取模，直接进opStack，并且将栈顶的优先级比现在高的都进行运算
            3.遇到数字则直接进入numStack
         最后返回numsStack栈顶元素，即为res答案。
         */
        //map存储运算优先级
        HashMap<Character,Integer> map = new HashMap<Character,Integer>(){
            {
                put('+',1);
                put('-',1);
                put('*',2);
                put('/',2);
            }
        };
        Deque<Integer> numStack = new LinkedList<Integer>();
        Deque<Character> opStack = new LinkedList<Character>();
        numStack.addFirst(0);   //头部加一个0，防止第一个数为负数，而被判定为减号-
        int n = s.length();
        for (int i=0;i<n;i++){
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            //下面则判断应该进那么栈里面
            if (isNumStack(ch)){    //如果是numStack
                //数字栈
                int j=i,num = 0;    //j记录当前操作的位置
                while (j <n && isNumStack(s.charAt(j)) ){   //注意那些有很多位的数字
                    num = num *10 +(s.charAt(j) - '0');
                    j++;
                }
                numStack.addFirst(num); //放入数字栈
                i = j-1;    //返回当前应该到那个地方了，因为有的数字占了i里面的好几位
            }else{      //如果是opStack
                //操作符栈
                        /*  解题思路：
                    1.肯定得用栈来实现，然后呢？
                    2.因为【乘法，除法】优先级更高，因此我们第一次操作时，只针对【乘法，除法】进行出栈计算操作，并把值返回栈中
                    3.第二次，再进行【加法，减法】的计算操作
                        */
                while (!opStack.isEmpty() && map.get(opStack.peekFirst()) >= map.get(ch)){
                    myCalculate(numStack,opStack);
                }
                opStack.add(ch);    //计算完前面的之后，这个操作符入栈
            }
        }// for (int i=0;i<n;i++)
        while (!opStack.isEmpty()) {    //第二次计算
            myCalculate(numStack,opStack);
        }
        return numStack.peekFirst();

    }

    /**
     *
     * @param numStack
     * @param opStack
     */
    private void myCalculate(Deque<Integer> numStack, Deque<Character> opStack) {
        if (opStack.isEmpty() || numStack.size() <2){
            return;
        }
        int b = numStack.pollFirst();
        int a = numStack.pollFirst();
        char c = opStack.pollFirst();
        if (c == '+'){
            numStack.addFirst(a+b);
        } else if (c == '-') {
            numStack.addFirst(a-b);
        }else if (c == '*') {
            numStack.addFirst(a*b);
        }else{
            numStack.addFirst(a/b);
        }
    }

    /**
     *
     * @param ch
     * @return
     */
    private boolean isNumStack(char ch) {
        if (ch >= '0' && ch <= '9'){
            return true;
        }
        return false;
    }
}
