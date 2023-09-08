package 西湖算法题解___中等题;

import java.util.*;

public class __49字母异位词分组__01 {
	/**
	 *
	 * @param strs
	 * @return
	 */
	public List<List<String>> groupAnagrams(String[] strs){
		//本质上，还是一种按组分类，用map效果会更好
		/*
		Map ->   (K,V)->(String,List<String>)
		 */
		Map<String,List<String>> listMap = new HashMap<String,List<String>>();
		//开始对每一个元素进行验证获取
		for (String str :strs){
			//str不能排序，因此把str转化成charArray
			char wantSortArray [] = str.toCharArray();
			Arrays.sort(wantSortArray);
			//开始用kv键值对进行存储
			String ifOnlyOne = new String(wantSortArray);
			//是唯一就自己生成一个单独的List<String>，不是唯一则加入到某一组中
			List<String> onlyList = listMap.getOrDefault(ifOnlyOne,new ArrayList<>());
			onlyList.add(str);
			//k是wantSortArray
			listMap.put(ifOnlyOne,onlyList);
		}
		return  new ArrayList<List<String>>(listMap.values());
	}

}
