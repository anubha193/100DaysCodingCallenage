package day9;

import java.util.ArrayList;
import java.util.*;

public class DetectCycleByDFS {
	  public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
	  {
		  boolean visit[] =new boolean[V]; 
	       for(int i = 0;i<V;i++) {
	           if(visit[i] == false) {
	               if(dfs(i,adj,visit,-1) == true) return true; 
	           }
	       }
	       return false; 
	    }
	    static boolean dfs(int v, ArrayList<ArrayList<Integer>> adj,boolean[] visit,int parent)
	    {
	        visit[v]=true;
	       for(int it:adj.get(v))
	       {
	           if(visit[it]==false)
	           {
	               if(dfs(it,adj,visit,v))return true;
	           }
	           else if(it!=parent)return true;
	          
	       }
	       return false; 
	  }
	 static void linkedList(int m,int n)
     {
   	  ArrayList<ArrayList<Integer>> al=new ArrayList<>();
   	  Scanner sc=new Scanner(System.in);
   	  for(int i=0;i<m;i++)
   	  {
   		  al.add(new ArrayList());
   	  }
   	   for(int i=0;i<m;i++)
   	   {
   		   System.out.println("enter the node values for "+(i+1)+"th node");
   	    	System.out.println("enter the value of first node");
   	    	int first=sc.nextInt();
   	    	System.out.println("enter the value of second node");
   	    	int second=sc.nextInt();
   	    	al.get(first).add(second);
   	    	al.get(second).add(first);
   	   }
   	   if(isCycle(m,al))
   		   System.out.println("graph has a cycle");
   	   else
   		   System.out.println("graph not has a cycle");
  	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the value of m");
		int m=sc.nextInt();
		System.out.println("enter the value of n");
		int n=sc.nextInt();
		linkedList(m,n);
	}

}
