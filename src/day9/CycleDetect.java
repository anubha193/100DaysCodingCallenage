package day9;
import java.util.*;
class value
{
    int second;
    int first;
    value(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
public class CycleDetect {
	  public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
	        // Code herev
	       boolean vis[] = new boolean[V];
	        Arrays.fill(vis,false);
	        int parent[] = new int[V];
	        Arrays.fill(parent,-1);  
	        
	        for(int i=0;i<V;i++)
	            if(vis[i]==false) 
	                if(cycle(adj,vis,i)) 
	                    return true;
	    
	        return false;
	        
	    }
	  
	    static boolean cycle(ArrayList<ArrayList<Integer>> adj,boolean[] vis,int v)
	    {
	        Queue<value> q=new LinkedList<>();
	        q.offer(new value(v,-1));
	        vis[v]=true;
	        while(!q.isEmpty())
	        {
	            int node=q.peek().first;
	            int par=q.peek().second;
	            q.poll();
	            for(int it:adj.get(node))
	            {
	               if(vis[it]==false)  
	               {
	                   q.add(new value(it, node));
	                   vis[it] = true; 
	               }
	               else if(par!= it) return true; 
	            }
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
