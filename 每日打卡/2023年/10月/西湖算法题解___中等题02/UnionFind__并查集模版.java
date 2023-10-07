package 西湖算法题解___中等题02;

import java.util.Arrays;

public class UnionFind__并查集模版 {
	int [] parent;
	int size [];
	int n;
	//当前连通分量数目
	int setCount;

	public UnionFind__并查集模版(int[] parent, int[] size, int n, int setCount) {
		this.parent = parent;
		this.size = size;
		this.n = n;
		this.setCount = setCount;
		Arrays.fill(size,1);
		for (int i=0;i<n;i++){
			parent[i] = i;
		}
	}


	public UnionFind__并查集模版(int i) {
	}

	public int findSet(int x){
		return parent[x] == x ? x : (parent[x] = findSet(parent[x]));
		//return parent[x] == x ? x : (parent[x] = findSet(parent[x]));
	}

	public boolean unite(int x,int y){
		x = findSet(x);
		y = findSet(y);
		if (x == y){
			return false;
		}
		if (size[x] < size[y]){
			int temp = x;
			x = y;
			y = temp;
		}
		parent[y] = x;
		size[x] += size[y];
		--setCount;
		return true;
	}

	public boolean connected(int x,int y){
		x = findSet(x);
		y = findSet(y);
		return x == y;
	}
}
