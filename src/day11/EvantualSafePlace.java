package day11;
import java.util.*;
public class EvantualSafePlace {
	static ArrayList<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> al) {

        // Your code here
       
        int[] visit=new int[V];
        int[] path=new int[V];
        for(int i=0;i<V;i++)
           {
               if(visit[i]==0)
               dfs(al,visit,path,i);
           }
           ArrayList<Integer> res=new ArrayList<>();
           for(int i=0;i<V;i++)
           {
               if(visit[i]==1 && path[i]==0)
               res.add(i);
           }
           return res;
    }
    static boolean dfs( ArrayList<ArrayList<Integer>> al,int[] visit,int[] path,int sr)
    {
        visit[sr]=1;
        path[sr]=1;
        for(int i:al.get(sr))
        { 
            if(visit[i]==0){
            if(dfs(al,visit,path,i)==true)return true;
            }
            else if(path[i]==1)return true;
        }
         path[sr]=0;
        return false;
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
