package day14;
import java.util.*;
public class SortedPathInADAG {
	public static int[] shortestPath(int n,int m, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> al=new ArrayList<>();
		for(int i=0;i<n;i++)
		{
		    ArrayList < Pair > pr = new ArrayList < Pair > ();
		    al.add(pr);
		}
		for (int i = 0; i < m; i++) {
      int u = edges[i][0];
      int v = edges[i][1];
      int wt = edges[i][2];
      al.get(u).add(new Pair(v, wt));
    }
    int[] visit=new int[n];
    Stack<Integer> st=new Stack<>();
    for(int i=0;i<n;i++)
    {
        if(visit[i]==0)
        dfs(al,st,visit,i);
    }
    int[] dis=new int[n];
    Arrays.fill(dis,(int)(1e9));
    dis[0] = 0;
    while(!st.isEmpty())
    {
     int node=st.peek();
     st.pop();
     for(int i=0;i<al.get(node).size();i++)
     {
         int v=al.get(node).get(i).first;
         int wt = al.get(node).get(i).second;
        if (dis[node] + wt < dis[v]) {
          dis[v] = wt + dis[node];
        }
        }
     }
     for(int i=0;i<n;i++)
     {
         if(dis[i]==(int)(1e9))
         dis[i]=-1;
     }
    
    return dis;
	}
	static void dfs(ArrayList<ArrayList<Pair>> al,Stack<Integer> st,int[] visit,int sr)
	{
	    visit[sr]=1;
	    for(int i=0;i<al.get(sr).size();i++)
	    {
	   int v = al.get(sr).get(i).first;
      if (visit[v] == 0) {
       dfs(al,st,visit,v);
      }
    }
    st.push(sr);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		int m=7;
        int edge[][]= {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int temp[]=shortestPath(n,m,edge);
        System.out.println("the sorted path form sourse to other node is=");
        for(int i=0;i<temp.length;i++)
        	System.out.print(temp[i]+" ");
	}

}
class Pair{
    int first;
    int second;
    public Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
