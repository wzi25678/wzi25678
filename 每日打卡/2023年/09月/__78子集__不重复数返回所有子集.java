package 西湖算法题解___中等题;

import java.util.ArrayList;
import java.util.List;

public class __78子集__不重复数返回所有子集 {
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());     //首先将空集加入其中
		for (int i=0;i< nums.length;i++){       //遍历数组中的每个元素
			int curSonSet = res.size();       //答案集合中的当前长度,即当前子集
			for (int j=0;j<curSonSet;j++){
				List<Integer> temp = new ArrayList<>(res.get(j));   //temp即遍历当前子集元素情况
				temp.add(nums[i]);      //向当前子集所有情况中，加入当前新元素
				//那么此时原来的当前子集就会丢失
				res.add(temp);          //因此每次最终答案中都要记录每次的当前子集情况
			}
		}
		return res;
	}

}
