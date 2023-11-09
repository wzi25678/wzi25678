package 日常Java程序测试.代码随想录.哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class __202快乐数__无限循环中去找是否存在的解集 {
	public static void main(String[] args) {
		isHappy(19);
	}
	/**
	 *对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
	 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
	 * 如果这个过程 结果为 1，那么这个数就是快乐数。
	 *
	 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
	 *
	 * 解题思路：
	 *      首先，明确怎么去正确的求解？
	 *      1.无限循环的话，很好搞，是吧，for，while都可以
	 *      2.无限循环中，怎么去找退出循环的解呢？   ---> 那就要去找退出循环的条件
	 *          2.1条件：遇到当前所有的数值的平方的和，加在一起等于1
	 *                  --->这个好办咯，只要有一个值记录一下本轮所有的数，是不是和为1就行
	 *       或者2.2条件：遇到了循环
	 *                  --->想要判断是否遇到循环，那么久必须要记录到前面的数，并且需要和之间的去判断
	 *                  --->就需要用到Set，看是否集合中已经有了该元素。
	 *
	 * @param n
	 * @return
	 */
	public static boolean isHappy(int n) {
		//除了1以外，没有哪个数的平方会等于自身
		//用数组去存储数字
		//boolean flag = false;
		Set<Integer> ifExist = new HashSet<>();
		//进行取模，取余，累积判断操作
		while ((n!=1 || n!= 0) && !ifExist.contains(n)){
			ifExist.add(n);
			int sum = 0;
			while (n!=0){
				int curNum = n%10;
				n/=10;
				sum+=curNum*curNum;
			}
			n = sum;
		}
		return (n==1 || n==0)?true:false;
	}
}
