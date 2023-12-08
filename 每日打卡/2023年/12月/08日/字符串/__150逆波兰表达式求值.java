package 代码随想录.字符串;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class __150逆波兰表达式求值 {
    /**
     * 逆波兰表达式求值，本质上就是一种栈的运用
     * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
     *
     *
     * 可以分为数字栈，运算符栈
     * 当然也可以不构造运算符栈，直接有效的算符为 '+'、'-'、'*' 和 '/' 。四个去判断
     * //个人感觉构造运算符栈，更具有通用性，但是这道题其实不用会更快一点
     * 然后数字栈遇到了运算符栈，就出栈两个，进行对应的计算求值。
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        //难点在于，一开始需要再String类型时，就去判别是数字还是字符
        //以及考虑到需要做数字上的加减乘除运算，那么应该设置为Integer类型的Stack
        Deque<Integer> numStack = new ArrayDeque<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = numStack.pop();
                int num1 = numStack.pop();
                if (token.equals("+")) {
                    numStack.push(num1 + num2);
                } else if (token.equals("-")) {
                    numStack.push(num1 - num2);
                } else if (token.equals("*")) {
                    numStack.push(num1 * num2);
                } else if (token.equals("/")) {
                    numStack.push(num1 / num2);
                }
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }
        return numStack.pop();
    }
}
