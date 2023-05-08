package day20;
import java.util.*;
import java.util.ArrayList;

public class AccountsMerge {
	static  ArrayList<Integer> parent=new ArrayList<>();
    static  ArrayList<Integer> rank=new ArrayList<>();
    AccountsMerge(int n)
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
    static ArrayList<ArrayList<String>> account(String[][] accounts)
    {
    	
    	HashMap<String, Integer> hm=new HashMap<>();
    	int n=accounts.length;
    	for(int i=0;i<n;i++)
    	{
    		String[] temp=accounts[i];
    		for(int j=1;j<temp.length;j++)
    		{
    			if(hm.containsKey(temp[j])==false) 
    			hm.put(temp[j], i);
    			else
    				unionByRank(i,hm.get(temp[j]));
    	    }
    	}
    	ArrayList<ArrayList<String>> al=new ArrayList<>();
    	for(int i=0;i<n;i++)
    		al.add(new ArrayList<String>());
    	for(Map.Entry<String, Integer> i:hm.entrySet())
    	{
    		String str=i.getKey();
    		int node=findParent(i.getValue());
    		al.get(node).add(str);
    	}
    	System.out.println(al);
    	ArrayList<ArrayList<String>> ans=new  ArrayList<>();
    	for(int i=0;i<n;i++)
    	{
    		ArrayList<String> temp=al.get(i);
    		if(temp.size()==0)continue;
    		Collections.sort(temp);
    		ArrayList<String> temp2 = new ArrayList<>();
    		temp2.add(accounts[i][0]);
    		for(String j:temp) {
    			temp2.add(j);
    		}
    		ans.add(temp2);
    	}
    	System.out.println(ans);
    	return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] accounts={{"John","johnsmith@mail.com","john_newyork@mail.com"},
{"John","johnsmith@mail.com","john00@mail.com"},
		                             {"Mary","mary@mail.com"},
		                             {"John","johnnybravo@mail.com"}};
		int n=accounts.length;
		AccountsMerge ac=new AccountsMerge(n);
		ArrayList<ArrayList<String>> result=account(accounts);
		System.out.println(result);

	}

}
