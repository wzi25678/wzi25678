package 日常Java程序测试.代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

public class __242有效的字母异位词 {
	/**
	 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
	 * 如果只是26个英文字母，那么可以直接用二维数组去存储26个单词，以及它们的对应个数
	 * 然后逐个判断，即可。
	 *
	 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
	 * 如果不知道字符类型个数，那么就得用到哈希表，HashMap去做key-value存储。
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()){
			return false;
		}
		Map<Character,Integer> map = new HashMap<Character,Integer> ();
		//先存好s的
		for (int i=0;i<s.length();i++){
			char ch = s.charAt(i);
			map.put(ch,map.getOrDefault(ch,0)+1);
		}
		//然后t去找对应的key-value去减少，如果减少到<0,,,那么说明该字符串不符合要求。
		for (int i=0;i<t.length();i++){
			char ch = t.charAt(i);
			map.put(ch,map.getOrDefault(ch,0)-1);
			//因为我当前用的是ch，那么对应去减少
			if (map.get(ch) < 0){
				return false;
			}
		}
		return true;
	}
}
