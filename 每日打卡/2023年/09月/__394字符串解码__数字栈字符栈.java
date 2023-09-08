package 西湖算法题解___中等题;

import java.util.ArrayDeque;
import java.util.Deque;

public class __394字符串解码__数字栈字符栈 {
			/*
		//感觉得用栈
		//用栈去检测 ]
		关键点：
			1.检测' ] '
			2.检测像字符19，代表的是数字19倍。

		方法一：数字栈+字母栈
		方法二：递归调用
		 */
	public String decodeString(String s) {
		//双栈解法：
		//准备两个栈：一个存放数字，一个存放字符串
		//遍历字符有四种情况
		//1、如果是数字 将数字转成整型数字等待处理
		//2、如果是字符 将字符添加到当前临时字符串中
		//3、如果是'['  将当前数字和临时字符串添加到各自栈中
		//4、如果是']'  将数字和字符栈各取出，然后拼接成新的临时字符串
		//Java 推荐用Deque ArrayDeque实现栈
		//创建数字栈，创建字符串栈 及临时数字和临时字符串
		StringBuilder stringBuilder = new StringBuilder();
		Deque<Integer> stackDights = new ArrayDeque<>();
		Deque<StringBuilder> stackChars = new ArrayDeque<>();
		int num = 0;    //int num = 0;    //用于记录数字倍数
		int index = 0; //记录遍历位置
		//会出现四种情况：  [ 、 ] 、 数字 、字符
		while (index < s.length()){
			char c = s.charAt(index++);
			if (c == '['){      //遇到'['说明，需要重新单开一个优先级，所以把之间的两个站都压进去
				stackDights.push(num);
				stackChars.push(stringBuilder);     //这里放的是StringBuilder类型的，所以构造的时候也得是StringBuilder类型。
				num = 0;    //num重新计数
				stringBuilder = new StringBuilder();    //stringBuilder也重新记录
			} else if (c ==']') {   //如果是"]" 将数字和字符串出栈 此时临时字符串res = 出栈字符串 + 出栈数字*res
				//统计当前[]范围内的情况
				StringBuilder temp = stackChars.pop();
				int count = stackDights.pop();
				for (int i = 0;i<count;i++){
					temp.append(stringBuilder.toString());
				}
				//记录pop出来的temp，然后temp复制对应倍数，在给stringBuilder
				stringBuilder = temp;
			} else if (0 <= 'c' && c <= '9') {
				//这里要做的就是十倍扩大
				num = 10 * num + c -'0';
			}else {     //字符
				//如果是字符，没啥管的，直接放进去就行
				stringBuilder.append(c);
			}
		}
		return stringBuilder.toString();
	}
}
