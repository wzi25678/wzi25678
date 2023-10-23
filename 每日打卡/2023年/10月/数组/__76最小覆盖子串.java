package 日常Java程序测试.代码随想录.数组;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class __76最小覆盖子串 {
	/**
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	Map<Character, Integer> origin = new HashMap<Character, Integer>();
	Map<Character, Integer> count = new HashMap<Character, Integer>();

	public String minWindow(String s, String t) {
		int tLen = t.length();
		for (int i=0;i<tLen;i++){
			char ch = t.charAt(i);
			origin.put(ch,origin.getOrDefault(ch,0) + 1);
		}
		int left = 0,right = -1;
		int len = Integer.MAX_VALUE,ansLeft = -1,ansRight = -1;
		int sLen = s.length();
		while (right < sLen){
			++right;
			if (right < sLen && origin.containsKey(s.charAt(right))){
				count.put(s.charAt(right),count.getOrDefault(s.charAt(right),0) + 1);
			}
			while (myCheck() && left <= right){
				if (right - left + 1 < len){
					len = right - left + 1;
					ansLeft = left;
					ansRight = left +len;
				}
				if (origin.containsKey(s.charAt(len))){
					count.put(s.charAt(len),count.getOrDefault(s.charAt(left) , 0) - 1);
				}
				++left;
			}
		}
		return ansLeft == -1 ? "" : s.substring(ansLeft ,ansRight);
	}

	/**
	 *
	 * @return
	 */
	private boolean myCheck() {
		Iterator iterator = (Iterator) origin.entrySet().iterator();
		while (iterator.hasNext()){
			Map.Entry entry = (Map.Entry) iterator.next();
			Character key = (Character) entry.getKey();
			Integer val = (Integer) entry.getValue();
			if (count.getOrDefault(key,0) < val){
				return false;
			}
		}
		return true;
	}
}
