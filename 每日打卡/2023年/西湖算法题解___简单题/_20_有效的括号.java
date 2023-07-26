package 西湖算法题解___简单题;

import java.util.Stack;

public class _20_有效的括号 {
	public static void main(String[] args) {
		String s = "";
		isValid(s);
	}

	private static boolean isValid(String s) {
		//先对输入值进行一个简单的遍历
		if (s.isEmpty()){
			return true;
		}

		//括号匹配，典型的要用栈来实现
		Stack<Character> stack = new Stack<>();

		//开始对每个字符进行判断
		for (char c : s.toCharArray()){
			if (c == '('){
				stack.push(')');
			}else if (c=='{'){
				stack.push('}');
			} else if (c=='[') {
				stack.push(']');
			}else if(stack.isEmpty() || c != stack.pop()){
				return false;
			}

		}

		return stack.isEmpty();
	}

}
