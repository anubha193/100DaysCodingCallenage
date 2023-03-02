package day12;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

public class DeteectCycleUsingTopologicalSort {
	static boolean topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
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

    ArrayList<Integer> topo=new ArrayList<>();
    while (!q.isEmpty()) {
        int node = q.peek();
        q.remove();
        topo.add(node);
        for (int it : adj.get(node)) {
            indegree[it]--;
            if (indegree[it] == 0) {
                q.add(it);
            }
        }
    }

    if(topo.size()==V)return false;
    return true;
	    }
	public static void main(String[] args) {
		int v=4;
          ArrayList<ArrayList<Integer>> al=new ArrayList<>();
          for(int i=0;i<v;i++)
        	  al.add(new ArrayList<>());
          al.get(0).add(1);
          al.get(1).add(2);
          al.get(2).add(3);
          al.get(2).add(1);
          if(topoSort(v,al))
        	  System.out.println("graph is cyclic");
          else
        	  System.out.println("not cyclic");
	}

}
