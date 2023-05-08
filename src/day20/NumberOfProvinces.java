package day20;
import java.util.*;
public class NumberOfProvinces {
	static  ArrayList<Integer> parent=new ArrayList<>();
    static  ArrayList<Integer> rank=new ArrayList<>();
	 NumberOfProvinces(int n)
   {
   	for(int i=0;i<=n;i++)
   	{
   		rank.add(0);
   		parent.add(i);
   	}
   }
   static int findParent(int u)
   {
   	if(parent.get(u)==u)return u;
   	int par=findParent(parent.get(u));
   	parent.set(u, par);
   	return findParent(parent.get(u));
   }
    static void unionByRank(int u,int v)
   {
    	int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv) return;
        if (rank.get(pu) < rank.get(pv)) {
            parent.set(pu, pv);
        } else if (rank.get(pv) < rank.get(pu)) {
            parent.set(pv, pu);
        } else {
            parent.set(pv, pu);
            int rankU = rank.get(pu);
            rank.set(pu, rankU + 1);
       }
   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int[][] edges= {{6 ,5},
    		   {0 ,1},
    		   {0, 2},
    		   {0, 3},
    		   {1 ,2},
    		   {1, 3}};
	NumberOfProvinces nm=new NumberOfProvinces(7);
	for(int i = 0;i<edges.length;i++) {
    	unionByRank(edges[i][0], edges[i][1]);}
	int count=0;
	for(int i=0;i<7;i++)
	{
			if(nm.findParent(i)==i)
				count++;
	}
	System.out.println(count);
	}
}
