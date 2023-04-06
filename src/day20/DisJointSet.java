package day20;
import java.util.*;
public class DisJointSet {
	static int parent[]=new int[7+1];
	 static int rank[]=new int[7+1];
	 DisJointSet(int n)
    {
    	for(int i=1;i<=n;i++)
    	{
    		rank[i]=0;
    		parent[i]=i;
    	}
    }
    static int findParent(int u)
    {
    	if(parent[u]==u)return u;
    	int par=findParent(parent[u]);
    	parent[u]= par;
    	return findParent(parent[u]);
    }
     static void unionByRank(int u,int v)
    {
    	int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) return;
        if (rank[u] == rank[v]) {
            parent[u]=v;
        } else if (rank[v] < rank[u]) {
            parent[v]=u;
        } else {
        	parent[u]=v;
            int rankU = rank[u];
            rank[u] =rankU + 1;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisJointSet ds=new DisJointSet(7);
		ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
	}

}
