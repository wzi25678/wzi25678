package 西湖算法题解___中等题;

public class __56合并区间 {
	public static void main(String[] args) {

	}

	/**
	 *
	 * @param intervals
	 * @return
	 */

//	public int[][] merge(int[][] intervals) {
//		int helper[] = new int[intervals[intervals.length-1][2]+1];
//		for (int i=0;i<intervals.length;i++){
//			int begin = intervals[i][0];
//			int end = intervals[i][1];
//			for (int j = begin;j<=end;j++){
//				helper[j] = 1;
//			}
//		}
//		//遍历一遍整个数组,获取有多少段
//		boolean duan = true;
//		int duan_num = 0;
//		for (int i=1;i< helper.length;i++){
//			if (helper[i] == 1 && duan == true){
//				duan_num++;
//				continue;
//			}
//			if (helper[i] == 0 ){
//				duan = false;
//			}
//			if (helper[i] == 1){
//				duan = true;
//			}
//		}
//		return new int[][];
//		//最后得到的duan_num即为段数
//
//	}
}
