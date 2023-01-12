#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

int check(int arr[9][9], int x, int y, int t)
{
	for (int i = 0; i < 9; i++)
	{
		if (arr[x][i] == t || arr[i][y] == t)
			return 0;
	}
	int maze[] = { 0,3,6 };
	int left = maze[x / 3];
	int right = maze[y / 3];
	for (int i = left; i < left + 3; i++)
	{
		for (int j = right; j < right + 3; j++)
		{
			if (arr[i][j] == t)
				return 0;
		}
	}
	return 1;
}
void dfs(int arr[9][9], int x, int y)
{
	if (x == 9)//找到唯一最优解
	{
		for (int i = 0; i < 9; i++)//输出
		{
			for (int j = 0; j < 9; j++)
			{
				printf("%d", arr[i][j]);
			}
			printf("\n");
		}
		return;
	}
	if (arr[x][y] == 0)
	{
		for (int i = 1; i <= 9; i++)//遍历合法数字填空
		{
			if (check(arr, x, y, i) == 1)//判断是否合法
			{
				arr[x][y] = i;//状态转移
				dfs(arr, x + (y + 1) / 9, (y + 1) % 9);//递归下一个坐标点，即深搜
			}
		}
		arr[x][y] = 0;//如果前面的循环都没有找到唯一的最优解，则回溯
	}
	else
	{
		dfs(arr, x + (y + 1) / 9, (y + 1) % 9);//递归搜索下一个坐标点
	}
}

int main()
{
	int arr[9][9] = { {0,0,5,3,0,0,0,0,0},
					{8,0,0,0,0,0,0,2,0},
					{0,7,0,0,1,0,5,0,0},
					{4,0,0,0,0,5,3,0,0},
					{0,1,0,0,7,0,0,0,6},
					{0,0,3,2,0,0,0,8,0},
					{0,6,0,5,0,0,0,0,9},
					{0,0,4,0,0,0,0,3,0},
					{0,0,0,0,0,9,7,0,0} };
	dfs(arr, 0, 0);
	system("pause");
	return 0;
}
