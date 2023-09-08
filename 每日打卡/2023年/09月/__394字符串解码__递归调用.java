package 西湖算法题解___中等题;

public class __394字符串解码__递归调用 {

	/*
	//感觉得用栈
	//用栈去检测 ]
	关键点：
		1.检测' ] '
		2.检测像字符19，代表的是数字19倍。

	方法一：数字栈+字母栈
	方法二：递归调用
	 */
	private int index = 0;  //因为两个函数里面都要用到index，所以直接放在外面
	public String decodeString(String s) {
		index = 0;
		return myDecode(s);
	}

	private String myDecode(String s) {
		int num = 0;    //用于记录数字倍数
		int index = 0;  //记录遍历位置
		StringBuilder stringBuilder = new StringBuilder();
		while (index < s.length()){
			char c = s.charAt(++index);
			//index++;
			if (c >= '0' && c <= '9'){
				num = num *10 + c - '0';
			} else if (c == '[') {
				//如果是左括号
				String str = myDecode(s);
				for (int j=0;j<num;j++){
					stringBuilder.append(str);
				}
				num = 0;
			} else if (c == ']') {
				break;
			}else {
				stringBuilder.append(c);
			}
		}
		return stringBuilder.toString();
	}


}
