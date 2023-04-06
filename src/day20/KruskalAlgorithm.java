package day20;
import java.util.*;
public class KruskalAlgorithm {
	static int parent[]=new int[3+1];
	 static int rank[]=new int[3+1];
	 KruskalAlgorithm(int n)
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
   public static void unionByRank(int u,int v)
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
		int v=3;
		int e=3;
		int edge[][]= {{5,0, 1},
				{3,1, 2},
				{1,0, 2}};
		PriorityQueue<tuple> q = 
		        new PriorityQueue<tuple>((x,y) -> x.first - y.first);
		        for(int i=0;i<e;i++)
		        {
		        	q.add(new tuple(edge[i][0],edge[i][1],edge[i][2]));
		        }
		KruskalAlgorithm dis=new KruskalAlgorithm(v);
		int sum=0;
		for(int i=0;i<e;i++)
		{
			if(dis.findParent(q.peek().second)!=dis.findParent(q.peek().third)) {
			dis.unionByRank(q.peek().second,q.peek().third);
			sum+=q.peek().first;
			q.poll();
			}
		}
		System.out.println(sum);

	}

}
class tuple
{
	int first;
	int second;
	int third;
	public tuple(int first,int second,int third)
	{
		this.first=first;
		this.second=second;
		this.third=third;
	}
}
