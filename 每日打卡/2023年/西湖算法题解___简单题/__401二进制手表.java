package 西湖算法题解___简单题;

import java.util.ArrayList;
import java.util.List;

public class __401二进制手表 {


	int hours [] =  new int[]{1,2,4,8,0,0,0,0,0,0};
	int minutes [] = new int[]{0,0,0,0,1,2,4,8,16,32};

	List<String> res = new ArrayList<>();
	public List<String> readBinaryWatch(int turnedOn){
		backtrack(turnedOn,0,0,0);
		return res;
	}

	private void backtrack(int num, int index, int hour, int mintue) {
		if (hour > 11  || mintue >59){
			return;
		}
		if (num==0){
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(hour).append(':');
			if (mintue <10){
				stringBuilder.append('0');
			}
			stringBuilder.append(mintue);
			res.add(stringBuilder.toString());
			return;
		}
		for (int i=index;i<10;i++){
			backtrack(num-1, i+1, hour+hours[i], mintue+minutes[i]);
		}


	}
}
