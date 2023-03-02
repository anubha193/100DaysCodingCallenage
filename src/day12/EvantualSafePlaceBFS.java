package day12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class EvantualSafePlaceBFS {
	 static ArrayList<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> adj) 
	 {
		 List<List<Integer>> alr = new ArrayList<>();
	        for (int i = 0; i < V; i++) {
	            alr.add(new ArrayList<>());
	        }
	        int indegree[] = new int[V];
	        for (int i = 0; i < V; i++) {
	            for (int it : adj.get(i)) {
	                alr.get(it).add(i);
	                indegree[i]++;
	            }
	        }

     Queue<Integer> q = new LinkedList<Integer>();
     
     for (int i = 0; i < V; i++) {
         if (indegree[i] == 0) {
             q.add(i);
         }
     }
    ArrayList<Integer> al=new ArrayList<>();
     while (!q.isEmpty()) {
         int node = q.peek();
         q.remove();
         al.add(node);
         for (int it : alr.get(node)) {
             indegree[it]--;
             if (indegree[it] == 0) {
                 q.add(it);
             }
         }
     }

     return al;
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
		ArrayList<Integer> res=eventualSafeNodes(v,al);
		System.out.println(res);
	}

}
