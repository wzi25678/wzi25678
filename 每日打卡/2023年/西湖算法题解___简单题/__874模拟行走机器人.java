package 西湖算法题解___简单题;

import java.util.HashSet;

public class __874模拟行走机器人 {
	public static void main(String[] args) {

	}

	public int robotSim(int[] commands, int[][] obstacles) {
		int res = 0;
		int x = 0,y=0;

		// 0表示向北，1表示向东，2表示向南，3表示向西(顺时针)
		int direction = 0;
		//用二维数组定义出四个方向
		int [][] dire_xy = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

		//存储障碍物
		HashSet<String> obstacleSet = new HashSet<String>();
		for (int obs[] : obstacles){
			//每个障碍坐标为一个一行两列的坐标
			obstacleSet.add(obs[0]+","+obs[1]);
		}

		//机器人开始行走
		for (int comm :commands){//comm即，我获得的命令
			//获取到方向命令
			if (comm == -2){
				direction = (direction == 0)? 3:direction-1;
			}
			else if (comm == -1){
				direction = (direction == 3)? 3:direction+1;
			}else {
				//获取到的是向前移动x个单位的命令,
				//每走一步都要判断是否遇到了障碍物，如果遇到了就走不了了，并且需要break移动指令。
				while ( comm-- >0 && !obstacleSet.contains(x +dire_xy[direction][0]+","+(y+dire_xy[direction][1]))){
					x+=dire_xy[direction][0];
					y+=dire_xy[direction][1];
				}
				res = Math.max(res,Math.abs(x)*Math.abs(x)+Math.abs(y)*Math.abs(y));
			}


		}
		return res;


	}//public int robotSim(int[] commands, int[][] obstacles)

}
