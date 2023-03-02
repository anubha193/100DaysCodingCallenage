package day11;
import java.util.*;
public class TopologicalSortDfs {
	 static int[] topoSort(int V, ArrayList<ArrayList<Integer>> al) 
	    {
		 int vis[] = new int[V];
	        Stack<Integer> st = new Stack<Integer>();
	        for (int i = 0; i < V; i++) {
	            if (vis[i] == 0) {
	                dfs(al,vis,i,st);
	            }
	        }

	        int ans[] = new int[V];
	        int i = 0;
	        while (!st.isEmpty()) {
	            ans[i++] = st.peek();
	            st.pop();
	        }
	        return ans;
	    }
	    static void dfs(ArrayList<ArrayList<Integer>> al,int[] visit,int node,Stack<Integer> st)
	    {
	        visit[node]=1;
	        for(int i:al.get(node))
	        {
	        	if(visit[i]==0)
	            dfs(al,visit,i,st);
	        }
	        st.push(node);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v=6;
		ArrayList<ArrayList<Integer>> al =new ArrayList<>(v);
		for(int i=0; i < v; i++) {
		    al.add(new ArrayList<Integer>());
		}
        al.get(5).add(0);
        al.get(5).add(2);
		al.get(4).add(0);
		al.get(2).add(3);
		al.get(3).add(1);
		al.get(4).add(1);
		int topo[]=topoSort(v,al);
		for(int i=0;i<topo.length;i++)
			System.out.print(topo[i]+" ");
	}

}
