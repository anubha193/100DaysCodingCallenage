package day18;
import java.util.*;
public class PathWithMaximumProbability {
	 public static double maxProbability(int n, int[][] grid, double[] suc, int start, int end) {
	     ArrayList<ArrayList<Pair>> al=new ArrayList<>();
	     for(int i=0;i<n;i++)
	     al.add(new ArrayList<>()); 
	     int m=grid.length;
	     for(int i=0;i<m;i++)
	     {
	        al.get(grid[i][0]).add(new Pair(grid[i][1],suc[i])); 
	        al.get(grid[i][1]).add(new Pair(grid[i][0],suc[i])); 
	     }
	     Queue<Pair> q = new PriorityQueue<Pair>((a,b) -> Double.compare(b.second, a.second));
	      q.add(new Pair(start,1.0));
	     double[] dis=new double[n];
	     Arrays.fill(dis, Double.MIN_VALUE);
	     while(!q.isEmpty())
	     {
	     int node=q.peek().first;
	     double dist=q.peek().second;
	     q.poll();
	     for(Pair it:al.get(node))
	     {
	         int en=it.first;
	         double ew=it.second;
	         if((ew*dist)>dis[en])
	         {
	             dis[en]=ew*dist;
	             q.add(new Pair(en,dis[en]));
	         }
	     }
	     }
	     return dis[end];
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[][] grid= {{0,1},{1,2},{0,2}};
      double[] succ= {0.5,0.5,0.2};
      int start=0;
      int end=2;
      int n=3;
      System.out.println("Path with Maximum Probability is="+maxProbability(n,grid,succ,start,end));
	}
}
class Pair
{
    int first;
    double second;
    public Pair(int first,double second)
    {
        this.first=first;
        this.second=second;
    }
}
