package 西湖算法题解___中等题;

import java.util.Arrays;

public class __875爱吃香蕉的珂珂 {
	/**
	 这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。    警卫已经离开了，将在 h 小时后回来。
	 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。
	 每个小时，她将会选择一堆香蕉，从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。

	 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。

	 提示：
	 1 <= piles.length <= 10^4
	 piles.length <= h <= 10^9
	 1 <= piles[i] <= 10^9


	 * @param piles
	 * @param h
	 * @return
	 */
	public int minEatingSpeed(int[] piles, int h) {
		//即求满足条件的最小值。
		//最大值最小化问题。
		Arrays.sort(piles);
		if (piles.length>=h){
			//输出这堆数里面的最大值。
			return piles[piles.length-1];
		}
		//注释里有解释，构造一个等式，去进行计算
		int lowEat = 1;
		int highEat = piles[piles.length-1];
		int res = highEat;  //res即为我要求的满足条件的最大最小值。
		while (lowEat<highEat){
			int speed = (highEat - lowEat) /2 +lowEat;      //假设吃香蕉的速度是 speed，取中间速度去吃
			long time = getTime(piles,speed);   //中间速度吃，所需要消耗的时间
			if (time <= h){     //如果这个时间小于h，说明当前时间可以吃完，我们应该继续找更小的时间
								//即，res要保存一下当前的中值speed，同时当前的中值speed要变成一下的highEat
				res = speed;
				highEat = speed;
			}else {
				//不够，则无法使用这个去满足条件
				lowEat = speed+1;
			}
		}
		return res;
	}

	/**
	 *计算当前安排下所需花费的时间
	 *
	 * @param piles
	 * @param speed
	 * @return
	 */
	private long getTime(int[] piles, int speed) {
		long time = 0L;
		for (int pile:piles){
//			//每一个都要向上取整
//			int curTime = (pile+speed-1)/speed;
//			time+=curTime;
			//每一个都要向上取整
			int curTime = (int) Math.ceil((double)pile/(double)speed);
			time+=curTime;
		}
		return time;
	}
}
