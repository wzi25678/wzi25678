package 西湖算法题解___中等题;

public class __718最长重复子数组__滑动窗口 {
	public int findLength(int[] nums1, int[] nums2) {
		int n = nums1.length,m = nums2.length;
		int res = 0;
		for (int i=0;i<n;i++){
			int len = Math.min(m,n-i);
			int maxLen = maxLength(nums1,nums2,i,0,len);
			res = Math.max(res,maxLen);
		}
		for (int i=0;i<m;i++){
			int len = Math.min(n,m-i);
			int maxLen = maxLength(nums1,nums2,0,i,len);
			res = Math.max(res,maxLen);
		}
		return res;
	}

	private int maxLength(int[] nums1, int[] nums2, int addA, int addB, int len) {
		int res = 0,k=0;
		for (int i=0;i<len;i++){
			if (nums1[addA+i] == nums2[addB+i]){
				k++;
			}else {
				k=0;
			}
			res = Math.max(res,k);
		}
		return res;
	}
}
