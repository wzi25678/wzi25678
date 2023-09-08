//package 西湖算法题解___中等题;
//
//import java.util.List;
//
//public class __60排列序列__优化01 {
//	private int K;
//	public String getPermutation(int n, int k) {
//		int allPermytationsArray []= new int [n];
//		for (int i=0;i< allPermytationsArray.length;i++){
//			allPermytationsArray[i] = i+1;
//		}
//		K = k;
//		int index = 0;  //用于记录这是第几个
//		List<Integer> res = null;
//		return AllSort(allPermytationsArray,0,index,res);
//	}
//
//	/**
//	 *
//	 * @param arr
//	 * @param start
//	 * @param index
//	 * @param result
//	 * @return
//	 */
//	private String AllSort(int[] arr, int start, int index,List<Integer> result) {
//		if (start == arr.length -1){
//			//每排序完一趟，index++；
//			result.add(Integer.valueOf((String.valueOf(arr))));
//		}else {
//			for (int i= start;i< arr.length;i++){
//				swap(arr,start,i);
//				AllSort(arr,start+1,index,result);
//				swap(arr,i,start);
//			}
//		}
//		index++;
//		if (index == K){
//			return result;
//		}
//
//
//	}
//
//	/**
//	 *
//	 * @param nums
//	 * @param i
//	 * @param j
//	 */
//	private void swap(int[] nums, int i,int j ){
//		int temp = nums[i];
//		nums[i] = nums[j];
//		nums[j] = temp;
//	}
//
//
//}
