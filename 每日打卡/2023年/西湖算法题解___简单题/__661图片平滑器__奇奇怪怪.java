package 西湖算法题解___简单题;

import java.util.Arrays;

public class __661图片平滑器__奇奇怪怪 {
	public static void main(String[] args) {
		String s = "loveleetcode";
		char c = 'e';
		shortestToChar(s,c);
	}

	public static int[] shortestToChar(String s, char c) {
		int answer[] = new int[s.length()];
		for (int i=0;i<s.length();i++){
			char index= s.charAt(i);
			System.out.println("当前的index是"+index);
			for (int  distance = 0;i+distance<s.length() || i-distance>=0;distance++){
				if ( i-distance>=0){
					char left = s.charAt(i-distance);
					if (i-distance >= 0 && left == c){
						System.out.println("选择了左边，其值为"+s.charAt(i-distance));
						answer[i] = distance;
						break;
					}
				}

				if (i+distance<s.length()){
					char right= s.charAt(i+distance);
					if ((i+distance) <= (s.length()-1) &&  right == c){
						System.out.println("选择了右边，其值为"+s.charAt(i+distance));
						answer[i] = distance;
						//right = s.charAt(i+distance);
						break;
					}
				}



//				if (left == c || right == c){
//					answer[i] = distance;
//				}

			}
			System.out.println("-----------------下一个---------------------");
		}

		System.out.println(Arrays.toString(answer));
		return answer;
	}


}
