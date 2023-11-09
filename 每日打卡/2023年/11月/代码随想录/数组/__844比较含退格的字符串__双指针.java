package 日常Java程序测试.代码随想录.数组;

public class __844比较含退格的字符串__双指针 {
	/**
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean backspaceCompare(String s, String t) {
		int i = s.length() - 1,j = t.length() - 1;
		int skipS = 0,skipT = 0;
		while (i>=0 || j>= 0){
			while (i>=0){
				if (s.charAt(i) == '#'){
					skipS++;
					i--;
				} else if (skipS > 0) {
					skipS--;
					i--;
				}else {
					break;
				}
			}
			while (j >= 0){
				if (t.charAt(j) == '#'){
					skipT++;
					j--;
				} else if (skipT > 0) {
					skipT--;
					j--;
				}else {
					break;
				}
			}
			if (i>=0 && j>=0){
				if (s.charAt(i)!= t.charAt(j)){
					return false;
				}
			}else{
				if (i>=0 || j>=0){
					return false;
				}
			}
			i--;
			j--;
		}
		return true;
	}
}
