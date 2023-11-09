package 日常Java程序测试.代码随想录.栈与队列;

import java.util.ArrayDeque;
import java.util.Deque;

public class __20有效的括号 {
	public static void main(String[] args) {
		isValid("()[]{}");
	}
	/**
	 * 遇到左括号就push进来，遇到右括号，就和栈顶匹配
	 * '('，')'，'{'，'}'，'['，']'
	 *
	 * @param s
	 * @return
	 */
	public  static boolean isValid(String s) {
		if(s.length() % 2 == 1){
			return false;
		}
		Deque<Character> stack = new ArrayDeque<Character>();
		for (int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			if (ch == '(' || ch == '{' || ch == '['){
				stack.push(ch);
			} else if (ch == ')') {
				if (!stack.isEmpty() && stack.peek() == '(' ){
					stack.pop();
				}else {
					return false;
				}
			}else if (ch == '}') {
				if (!stack.isEmpty() && stack.peek() == '{' ) {
					stack.pop();
				} else {
					return false;
				}
			}else if (ch == ']') {
				if (!stack.isEmpty() && stack.peek() == '[' ){
					stack.pop();
				}else {
					return false;
				}
			}
		}
		if (stack.isEmpty()){
			return true;
		}
		return false;
	}
}
