
/*
思路一：
把十进制的数转化为k进制，k个k进制的数进行不进位相加，结果是0；那么剩下的就是那个出现一次的数。
eg：有10个11进行相加，原本1*10=10，原本应该进位的1舍去，就只能剩下0了。

思路二：
辅助数组，但是得根据具体题目来构造数组大小，得看题目是否刁钻。
*/
public class _07_出现k次 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr= {2,2,2,9,7,7,7,3,3,3,6,6,6,0,0,0};
		int len=arr.length;//len:16
		char[][] kRadix=new char[len][];   //kRadix:char[16][]
		int k=3;
		
		int maxlen=0;
		//转成k进制字符数组
		//对于每个数字
		for(int i=0;i<len;i++) {
			kRadix [i]=new StringBuilder(Integer.toString(arr[i],k)).reverse().toString().toCharArray();
			if(kRadix[i].length>maxlen) {
				maxlen=kRadix[i].length;
			}
		}
		
		int[] resArr =new int[maxlen];
		for(int i=0;i<len;i++) {
			//不进制加法
			for(int j=0;j<maxlen;j++) {
				if(j>=kRadix[i].length)
					resArr[j]+=0;
				else
					resArr[j]+=(kRadix[i][j]-'0');
			}
		}
		
		int res=0;
		for(int i=0;i<maxlen;i++) {
			res += (resArr[i]%k)*(int)(Math.pow(k, i));
		}
		System.out.println(res);
	}

}

