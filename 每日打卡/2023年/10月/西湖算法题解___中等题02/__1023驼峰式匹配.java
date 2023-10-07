package 西湖算法题解___中等题02;

import java.util.ArrayList;
import java.util.List;

public class __1023驼峰式匹配 {
	/**
	 题目理解：
	    即有一个需要配对的---字符串数组 queries
	     和一个用于配对的---模式的字符串 pattern
	 返回配对情况true/false

	 配对规则：
	    首先就是开头就要大写匹配，然后有小写的话，只要有就行
	    然后又到大写，去匹配，如果需要配对的字符串pattern匹配完成，则返回true
	    如果还有字符串数组 queries还有大写字母没有匹配到，则返回false。

	 * @param queries
	 * @param pattern
	 * @return
	 */
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		int n = queries.length;
		List<Boolean> ans = new ArrayList<Boolean>();
		for (int i=0;i<n;i++){
			boolean flag = true;
			int p=0;    //统计匹配到的个数
			for (int j=0;j<queries[i].length();j++){    //对每个区进行遍历
				char ch = queries[i].charAt(j);     //然后获取每一个字符
				if ( p < pattern.length() && pattern.charAt(p)==ch){
					p++;
				} else if (Character.isUpperCase(ch)) { //后面都不匹配也没关系，但是千万不能再出现大写字母了。
					flag = false;   //如果是大写字母，则向后进行匹配
					break;
				}
			}
			if (p <pattern.length()){
				flag = false;
			}
			ans.add(flag);
		}
		return ans;
	}
}
