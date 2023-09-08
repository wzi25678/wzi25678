package 西湖算法题解___中等题;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class __150逆波兰表达式求值 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param tokens
	 * @return
	 */
	public int evalRPN(String[] tokens) {
		//用栈来实现
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (String token : tokens){
			if (isOperator(token)){     //当前是不是操作符
				//是操作符，则需要将其出栈了
				int operand2 = stack.pop();     //先出后面的
				int operand1 = stack.pop();     //再出前面的
				int result = calculate(token,operand1,operand2);
				stack.push(result);     //在把当前阶段计算出来的结果，压入栈中
			}else { //不是，就把当前String类型的元素转换成Int型
				int operand  = Integer.parseInt(token);
				stack.push(operand);    //再压入栈中
			}
		}
		return stack.pop();
	}

	/**
	 *
	 * @param operator
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	private int calculate(String operator, int operand1, int operand2) {
		switch (operator){
			case "+":
				return operand1+operand2;
			case "-":
				return operand1-operand2;
			case "*":
				return operand1*operand2;
			case "/":
				return operand1/operand2;
			default:
				throw new IllegalArgumentException("输入的有效的算术符错误，你输入的是："+operator);
		}
	}

	/**
	 *
	 * @param token
	 * @return
	 */
	private boolean isOperator(String token) {
		if (token.equals("+") || token.equals("-") ||token.equals("*") ||token.equals("/") ){
			return true;
		}else {
			return false;
		}
	}
}
