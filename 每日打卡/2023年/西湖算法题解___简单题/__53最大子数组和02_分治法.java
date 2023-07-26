package 西湖算法题解___简单题;

public class __53最大子数组和02_分治法 {

	public static void main(String[] args) {
	}

	public class SubArray_Status{
		public int lSum, rSum, mSum, iSum;

		public SubArray_Status(int lSum, int rSum, int mSum, int iSum) {
			this.lSum = lSum;
			this.rSum = rSum;
			this.mSum = mSum;
			this.iSum = iSum;
		}

	}//class SubArray_Status

	public int maxSubArray(int nums[]){
		return getInfo(nums,0,nums.length-1).mSum;
	}

	private SubArray_Status getInfo(int[] a, int l, int r){
		if (l == r){
			return  new SubArray_Status(a[l],a[l], a[l],a[l]);
		}
		int m = (l+r) >> 1;
		SubArray_Status lSub = getInfo(a,l,m);
		SubArray_Status rSub = getInfo(a,m+1,r);
		return pushUp(lSub,rSub);
	}

	private SubArray_Status pushUp(SubArray_Status l, SubArray_Status r) {
		int iSum = l.iSum + r.iSum;
		int lSum = Math.max(l.lSum,l.iSum+r.lSum);
		int rSum = Math.max( r.rSum,l.rSum + r.iSum);
		int mSum = Math.max(Math.max(l.mSum,r.mSum),l.rSum+r.lSum);

		return new SubArray_Status(iSum,lSum,rSum,mSum);
	}


}







