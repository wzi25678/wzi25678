package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.List;

public class __17电话号码的字母组合__回溯法模拟 {
	public static void main(String[] args) {

	}
	//构建一个静态的公共数字到号码的映射
	private  String[] map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

	//路径
	private StringBuilder stringBuilder = new StringBuilder();

	//用于保存的结果集
	private List<String> res = new ArrayList<>();

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0){
			return res;
		}
		backtrack(digits,0);
		return res;
	}//public List<String> letterCombinations(String digits)

	private void backtrack(String digits, int index) {
		if (stringBuilder.length() == digits.length()){
			res.add(stringBuilder.toString());
			return;
		}
		String val = map[digits.charAt(index)-'2'];
		for (char ch :val.toCharArray()){
			stringBuilder.append(ch);
			backtrack(digits,index+1);
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
	}//private void backtrack(String digits, int index)
}
