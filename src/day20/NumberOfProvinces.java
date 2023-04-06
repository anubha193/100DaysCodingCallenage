package day20;
import java.util.*;
public class NumberOfProvinces {
	static int parent[]=new int[7+1];
	 static int rank[]=new int[7+1];
	 NumberOfProvinces(int n)
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
       int[][] edges= {{1, 0, 1},
    		   {0, 1, 0},
    		   {1, 0, 1}};
	int n=edges.length;
	NumberOfProvinces nm=new NumberOfProvinces(n);
	ArrayList<ArrayList<Integer>> al=new ArrayList<>();
	for(int i=0;i<n;i++)
		al.add(new ArrayList<Integer>());
	for(int i = 0;i<n;i++) {
        for(int j = 0;j<n;j++) {
            // self nodes are not considered 
            if(edges[i][j] == 1 && i != j) {
                al.get(i).add(j); 
                al.get(j).add(i); 
            }
        }
    }
	for(int i=0;i<n;i++)
	{
		for(int j:al.get(i))
		{
			nm.unionByRank(i, j);
		}
	}
	int count=0;
	for(int i=0;i<n;i++)
	{
			if(nm.findParent(i)==i)
				count++;
	}
	System.out.println(count);
	}
}
