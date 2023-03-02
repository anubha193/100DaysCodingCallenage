package day14;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SortestPathInUndirectedGraph {
	public static int[] shortestPath(int[][] edge,int n,int m ,int src) {
        // Code here
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(int i=0;i<n;i++)
        al.add(new ArrayList<Integer>());
        for(int i=0;i<m;i++)
        {
            int u=edge[i][0];
            int v=edge[i][1];
            al.get(u).add(v);
            al.get(v).add(u);
        }
        Queue<Integer> q=new LinkedList<>();
        int dis[]=new int[n];
        Arrays.fill(dis,(int)(1e9));
        dis[src]=0;
        q.add(src);
        while(!q.isEmpty()) {
            int node = q.peek(); 
            q.remove(); 
            for(int i : al.get(node)) {
                if(dis[node] + 1 < dis[i]) {
                    dis[i] = 1 + dis[node]; 
                    q.add(i); 
                }
            }
    }
     for(int i = 0;i<n;i++) {
            if(dis[i] == 1e9) {
                dis[i] = -1; 
            }
        }
     return dis;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		int m=7;
        int edge[][]= {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int temp[]=shortestPath(edge,n,m,0);
        System.out.println("the sorted path form sourse to other node is=");
        for(int i=0;i<temp.length;i++)
        	System.out.print(temp[i]+" ");
	}

}
