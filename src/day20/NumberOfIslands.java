package day20;
import java.util.*;
public class NumberOfIslands {
	static  ArrayList<Integer> parent=new ArrayList<>();
    static  ArrayList<Integer> rank=new ArrayList<>();
    NumberOfIslands(int n)
   {
   	for(int i=0;i<=n;i++)
   	{
   		rank.add(0);
   		parent.add(i);
   	}
   }
   static int findParent(int u)
   {
   	if(parent.get(u)==u)return u;
   	int par=findParent(parent.get(u));
   	parent.set(u, par);
   	return findParent(parent.get(u));
   }
    static void unionByRank(int u,int v)
   {
    	int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) return;
        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else if (rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            int rankU = rank.get(pu);
            rank.set(pu, rankU + 1);
       }
   }
	 public  static ArrayList<Integer> numOfIslands(int rows, int cols, int[][] arr)
	 {
		 int count=0;
		 int[] visit=new int[rows*cols];
		 ArrayList<Integer> al=new ArrayList<>();
		 int delrow[]= {1,-1,5,-5};
		 for(int i=0;i<arr.length;i++)
		 {   
			 int num=arr[i][0]*cols+arr[i][1];
			 if(visit[num] == 1) {
	                al.add(count);
	                continue;
	            }
			 visit[num]=1;
			 count++;
			 for(int j=0;j<4;j++)
			 {
				 int newcol=num+delrow[j];
				 if( newcol>=0 && newcol<(rows*cols) && visit[newcol]==1)
				 {
					if(findParent(visit[num])!=findParent(visit[newcol]))
					{
						unionByRank(visit[num],visit[newcol]);
						count--;
					}
					else
						count--;
						
				 }
			 }
			 al.add(count);
		 }
		 System.out.println(al);
		 return al;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int m = 5;
		int k = 10;
		NumberOfIslands nm=new NumberOfIslands(n*m);
		int[][]	A = {{1, 1},{0, 3},{2, 3},{2, 4},{2, 4},{2, 1},{1, 4},{0, 0},{1, 2},{2, 0}};
		System.out.println(numOfIslands(n,m,A));
	}

}
