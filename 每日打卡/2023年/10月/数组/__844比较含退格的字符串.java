package 日常Java程序测试.代码随想录.数组;

public class __844比较含退格的字符串 {
	/**
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean backspaceCompare(String s, String t) {   //判断含有退格符#，之后，还能否保持相等。
		/**
		 * 最容易想到的方法是将给定的字符串中的退格符和应当被删除的字符都去除，还原给定字符串的一般形式。
		 * 然后直接比较两字符串是否相等即可。
		 *
		 *具体地，我们用栈处理遍历过程，每次我们遍历到一个字符：
		 *   用栈去存储，模拟字符串String的存储情况
		 *   - 如果它是退格符，那么我们将栈顶弹出；
		 *   - 如果它是普通字符，那么我们将其压入栈中。
		 */
		//你可以用 O(n) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？

		//给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
		//  #代表退格符
		//用两个指针，分别指向需要匹配的位置，就可以模拟退格？
		//还真可以，不过还得把String[]  转化成数组
		return myBuild(s).equals(myBuild(t));
	}

	/**
	 *
	 * @param str
	 * @return
	 */
	private String myBuild(String str) {
		StringBuilder retStringBuilder = new StringBuilder();
		int length = str.length();
		for (int i=0;i<length;i++){
			char ch = str.charAt(i);
			if (ch != '#'){
				retStringBuilder.append(ch);
			}else {
				if (retStringBuilder.length() > 0){
					//这个deleteCharAt方法讲真，很高级！
					retStringBuilder.deleteCharAt(retStringBuilder.length() - 1);
				}
			}
		}
		return retStringBuilder.toString();
	}
}
