package day11;
import java.util.*;
public class TopologicalSort {
	 static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
	 {
	 int indegree[] = new int[V];
     for (int i = 0; i < V; i++) {
         for (int it : adj.get(i)) {
             indegree[it]++;
         }
     }

     Queue<Integer> q = new LinkedList<Integer>();
     
     for (int i = 0; i < V; i++) {
         if (indegree[i] == 0) {
             q.add(i);
         }
     }

     int topo[] = new int[V];
     int i = 0;
     while (!q.isEmpty()) {
         int node = q.peek();
         q.remove();
         topo[i] = node;
         i++;
         for (int it : adj.get(node)) {
             indegree[it]--;
             if (indegree[it] == 0) {
                 q.add(it);
             }
         }
     }

     return topo;
	    }
	public static void main(String[] args) {
		int v=6;
		ArrayList<ArrayList<Integer>> al =new ArrayList<>(v);
		for(int i=0; i < v; i++) {
		    al.add(new ArrayList());
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
