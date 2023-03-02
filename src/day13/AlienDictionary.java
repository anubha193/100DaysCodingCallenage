package day13;
import java.util.*;
public class AlienDictionary {
	public static String findOrder(String [] dict, int n, int k)
    {
        // Write your code here
        ArrayList<ArrayList<Integer>> al=new ArrayList<>();
        for(char i=0;i<k;i++)
        al.add(new ArrayList<Integer>());
         for(int i=0;i<n-1;i++)
         {
             String s1=dict[i];
             String s2=dict[i+1];
             int len=Math.min(s1.length(),s2.length());
             for(int j=0;j<len;j++)
             {
                 if(s1.charAt(j)!=s2.charAt(j))
                 {
                 al.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                 break;
                 }
             }
         }
         int vis[] = new int[k];
	        Stack<Integer> st = new Stack<Integer>();
	        for (int i = 0; i < k; i++) {
	            if (vis[i] == 0) {
	                dfs(al,vis,i,st);
	            }
	        }

	       String ans="";
	        int i = 0;
	        while (!st.isEmpty()) {
	            ans=ans+(char)(st.peek()+(int)('a')) ;
	            st.pop();
	        }
	        return ans;
	    }
	    static void dfs(ArrayList<ArrayList<Integer>> al,int[] visit,int node,Stack<Integer> st)
	    {
	        visit[node]=1;
	        for(int i:al.get(node))
	        {
	        	if(visit[i]==0)
	            dfs(al,visit,i,st);
	        }
	        st.push(node);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sq="bdac";
		String [] st= {"baa","abcd","abca","cab","cad"};
		if(sq.equals(findOrder(st,5,4)))
			System.out.println("True");
		else System.out.println("false");

	}

}
