package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class __816模糊坐标 {
	/**
	 题目概述：
	    本题就是说返回一个字符串，按指定条件拆分后的拼出来的所有坐标的个数

	 指定条件有：
	    就是按照正常的数字形式展示，不能有00 ,00. ，之类的，然后要求去重。

	 * @param s
	 * @return
	 */
	public List<String> ambiguousCoordinates(String s) {
		//枚举所有可能的情况
		int n = s.length() -2;
		List<String> res = new ArrayList<String>();
		s = s.substring(1,s.length()-1);    //直接把除第一个以外的所有元素赋给s
					 //从0坐标开始计数，前闭后开
		for (int l = 1;l < n;l++){
			List<String> lt = getPos(s.substring(0,l));
			if (lt.isEmpty()){
				continue;
			}
			List<String> rt = getPos(s.substring(l));
			if (rt.isEmpty()){
				continue;
			}
			for (String i:lt){
				for (String j:rt){
					res.add("("+i+","+j+")");
				}
			}
		}
		return res;
	}

	/**
	 *
	 * @param s
	 * @return
	 */
	private List<String> getPos(String s) {
		List<String> pos = new ArrayList<String>();
		if (s.charAt(0) != '0' || "0".equals(s)){
			pos.add(s);
		}
		for (int p = 1;p<s.length();p++){
			if ((p!=1 && s.charAt(0) == '0') || s.charAt(s.length() - 1 ) == '0'){
				continue;
			}
			pos.add(s.substring(0,p) + "." + s.substring(p));
		}
		return pos;
	}
}
