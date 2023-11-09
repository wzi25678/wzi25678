package 日常Java程序测试.代码随想录.哈希表;

import java.util.HashMap;
import java.util.Map;

public class __383赎金信 {
	/**
	 * 没有时间要求，随便搞，然后纯数字类啊，纯字母类啊都可以考虑使用字典进行记录
	 * 1.用magazine去匹配ransomNote
	 * 2.数组结构存储
	 *
	 *
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public boolean canConstruct(String ransomNote, String magazine) {
		//key代表字母     value代表该值的实现次数
		//Map<String,Integer> map = new HashMap<String,Integer>();
		int arr_ransomNote [] = new int[26];
		int arr_magazine [] = new int[26];
		for (int i=0;i<ransomNote.length();i++){
			arr_ransomNote[ransomNote.charAt(i)-97]++;
		}
		for (int i=0;i<magazine.length();i++){
			arr_magazine[magazine.charAt(i)-97]++;
		}
		for (int i=0;i<26;i++){
			if (arr_ransomNote[i]!=0){
				if (arr_ransomNote[i]>arr_magazine[i]){
					return false;
				}
			}
		}
		return true;
	}
}
