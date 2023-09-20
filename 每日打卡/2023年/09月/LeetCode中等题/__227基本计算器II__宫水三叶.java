package LeetCode中等题;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public class __227基本计算器II__宫水三叶 {
    //因为当前的Map还要定义在其他的函数里，故，我直接定义成全局变量
        //这里使用map去维护一个运算优先级
        //这里的优先级划分，我们就用K-V中的V去进行判断划分。
    Map<Character,Integer> stack_map = new HashMap<Character,Integer>(){{
        put('+',1);
        put('-',1);
        put('*',2);
        put('/',2);
        put('%',2);
        put('^',3);
    }};

    /**
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        /**
         * 需要注意输入数据里面有两个大坑：
         *      1.就是中间有空格隔开
         *      2.就是注意比如：1234这个数字，它在后面的数字栈中会占四个坑
         */
        //s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
        s.replaceAll(" ","");
        //s.replace(" ","");
        char [] chs = s.toCharArray();   //将字符串所有的字符存储到char里面去。
        int n = s.length();
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
        Deque<Integer> numStack = new LinkedList<Integer>();
        Deque<Character> opStack = new LinkedList<Character>();
        numStack.addFirst(0);   //头部加一个0，防止第一个数为负数，而被判定为减号-
        //------下面开始遍历整个字符数组----------------------------
        for (int i=0;i<n;i++){
            char c = chs[i];
            if (c == '('){  //这个优先级非常高
                opStack.addLast(c); //压入占中
            } else if (c == ')') {
                //就要对栈从（    进行计算
                while (!opStack.isEmpty()){
                    if (opStack.peekLast() != '('){     //如果不等于( ,则找数字栈里面元素和操作栈里面元素进行操作
                        myCalculate(numStack,opStack);
                    }else{
                        //如果等于( ，则就直接返回，并且退出当前 ')'的判断
                        opStack.pollLast();
                        break;
                    }
                }
            }else {     //如果没有出现上述的（）情况，则是进行正常的符号操作判断
                if (isNumStack(c)){    //如果是numStack
                    //数字栈
                    int j=i,num = 0;    //j记录当前操作的位置
                    while (j <n && isNumStack(chs[j]) ){   //注意那些有很多位的数字
                        num = num *10 +(chs[j] - '0');
                    }
                    numStack.addLast(num);
                    i = j-1;
                }else{      //如果是opStack
                    //操作符栈
                        /*  解题思路：
                    1.肯定得用栈来实现，然后呢？
                    2.因为【乘法，除法】优先级更高，因此我们第一次操作时，只针对【乘法，除法】进行出栈计算操作，并把值返回栈中
                    3.第二次，再进行【加法，减法】的计算操作
                        */
                    if (i>0 && (chs[i-1] == '(' || chs[i-1] == '+' || chs[i-1] == '-')){
                        numStack.addLast(0);
                    }
                    while (!opStack.isEmpty() && opStack.peekLast() != '('){
                        char prev = opStack.peekLast();
                        if (stack_map.get(prev) >= stack_map.get(c)){
                            myCalculate(numStack,opStack);
                        }else{
                            break;
                        }
                    }
                    opStack.addLast(c);    //计算完前面的之后，这个操作符入栈
                }
            }
        }
        //最后再讲剩余的不带符号的一些运算再操作一遍
        while (!opStack.isEmpty()){
            myCalculate(numStack,opStack);
        }
        return numStack.peekLast();
    }

    private boolean isNumStack(char c) {
        if (c >='0' && c <= '9'){
            return true;
        }else{
            return false;
        }
        //另外的表达：
            //return (c >='0' && c <= '9')? true:false;
        //另外的表达：
            //return Character.isDigit(c);
    }

    private void myCalculate(Deque<Integer> numStack, Deque<Character> opStack) {
        if (opStack.isEmpty() || numStack.size() <2 || opStack.isEmpty()){
            return;
        }
        int b = numStack.pollLast();
        int a = numStack.pollLast();
        char opChar = opStack.pollLast();
        int res = 0;
        if (opChar == '+'){
           res = (a+b);
        } else if (opChar == '-') {
            res = (a-b);
        }else if (opChar == '*') {
            res = (a*b);
        }
        else if (opChar == '^') {
            res = (int) Math.pow(a,b);
        }
        else if (opChar == '%') {
            res = (a%b);
        }else{
            res = (a/b);
        }
        numStack.addLast(res);
    }
}
