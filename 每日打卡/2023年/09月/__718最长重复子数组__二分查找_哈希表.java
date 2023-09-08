package 西湖算法题解___中等题;

import java.util.HashSet;
import java.util.Set;

public class __718最长重复子数组__二分查找_哈希表 {
	int mod = 1000000009;
	int base = 113;
	public int findLength(int[] nums1, int[] nums2) {
		int left = 1,right = Math.min(nums1.length,nums2.length)+1;
		while (left < right){
			int mid = (left + right) >> 1;
			if (myCheck(nums1,nums2,mid)){
				left = mid +1;
			}else {
				right = mid;
			}
		}
		return left - 1;
	}

	private boolean myCheck(int[] A, int[] B, int len) {
		long hashA = 0;
		for (int i=0;i<len;i++){
			hashA = (hashA * base + A[i]) % mod;
		}
		Set<Long> bucketA = new HashSet<Long>();
		bucketA.add(hashA);
		long mult = qPow(base,len - 1);
		for (int i = len;i < A.length;i++){
			hashA = ((hashA - A[i - len] * mult % mod + mod) % mod * base + A[i]) % mod;
			bucketA.add(hashA);
		}
		long hashB = 0;
		for (int i=0;i<len;i++){
			hashB = (hashB * base +B[i])%mod;
		}
		if (bucketA.contains(hashB)){
			return true;
		}
		for (int i=len;i<B.length;i++){
			hashB = ((hashB - B[i - len] * mult % mod + mod) % mod * base + B[i]) % mod;
			if (bucketA.contains(hashB)){
				return true;
			}
		}
		return false;
	}

	/**
	 * 使用快速幂计算x^n % mod 的值
	 * @param x
	 * @param n
	 * @return
	 */
	private long qPow(long x, long n) {
		long res = 1L;
		while (n != 0){
			if ((n&1) != 0){
				res = res * x % mod;
			}
			x = x*x % mod;
			n >>= 1;
		}
		return res;
	}
}
