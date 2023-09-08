package 西湖算法题解___中等题;

import java.util.*;

public class __49字母异位词分组__Auth {
	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for (String str : strs){
			char [] array = str.toCharArray();
			Arrays.sort(array);
			String onlyOne = new String(array);
			List<String> list = map.getOrDefault(onlyOne,new ArrayList<String>());
			list.add(str);
			map.put(onlyOne,list);
		}
		return new ArrayList<List<String>>(map.values());
	}//public List<List<String>> groupAnagrams(String[] strs)
}
