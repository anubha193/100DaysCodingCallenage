package day18;
import java.util.*;
public class NetworkDelayTime {
	public static int networkDelayTime(int[][] grid, int n, int k) {
	      ArrayList<ArrayList<Par>> al=new ArrayList<>();
	      for(int i=0;i<=n;i++)
	      al.add(new ArrayList<>());
	      int m= grid.length;
	      for(int i=0;i<m;i++)
	      {
	          al.get(grid[i][0]).add(new Par(grid[i][1],grid[i][2]));
	      } 
	      int[] dis=new int[n+1];
	      Arrays.fill(dis,(int)10e9);
	     PriorityQueue<Par> q = 
	        new PriorityQueue<Par>((x,y) -> x.first - y.first);
	        q.add(new Par(k,0));
	        dis[k]=0;
	        dis[0]=0;
	        int count=0;
	         while(q.size() != 0) {
	            int dist = q.peek().second; 
	            int node = q.peek().first; 
	            q.poll(); 
	            for(Par it:al.get(node)) {
	                int en = it.first; 
	                int ew = it.second; 
	                if(dist + ew < dis[en]) {
	                    dis[en] = dist + ew ; 
	                     count=Math.max(count,dis[en]);
	                    q.add(new Par(en,dis[en])); 
	                }
	            }
	        }
	      int min=Integer.MIN_VALUE;
			for(int i : dis){
				min=Math.max(min,i);
			}
			return min==Integer.MAX_VALUE?-1:min;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid= {{2,1,1},{2,3,1},{3,4,1}};
		int n=4;
		int k=2;
		System.out.println(" Network Delay Time is="+networkDelayTime(grid,n,k));}}
class Par
{
    int first;
    int second;
    public Par(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
