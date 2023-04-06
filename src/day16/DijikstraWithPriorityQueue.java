package day16;
import java.util.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DijikstraWithPriorityQueue {
	static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> al, int src)
    {
      Queue<name> q = 
        new LinkedList<>();
        int []dist = new int[V]; 
        Arrays.fill(dist,(int)(1e9));
        dist[src] = 0;
        q.add(new name(0,src)); 
        while(q.size() != 0) {
            int dis = q.peek().dis; 
            int node = q.peek().node; 
            q.remove(); 
            for(int i = 0;i<al.get(node).size();i++) {
                int en = al.get(node).get(i).get(0); 
                int ew = al.get(node).get(i).get(1); 
                if(dis + ew < dist[en]) {
                    dist[en] = dis + ew ; 
                    q.add(new name(dist[en], en)); 
                }
            }
        }
        return dist; 
    }
	public static void main(String[] args) throws IOException {
        int V = 3, E=3,S=2;
   ArrayList<Integer> node1 = new ArrayList<Integer>() {{add(1);add(1);}};
   ArrayList<Integer> node2 = new ArrayList<Integer>() {{add(2);add(6);}};
   ArrayList<Integer> node3 = new ArrayList<Integer>() {{add(2);add(3);}};
   ArrayList<Integer> node4 = new ArrayList<Integer>() {{add(0);add(1);}};
   ArrayList<Integer> node5 = new ArrayList<Integer>() {{add(1);add(3);}};
   ArrayList<Integer> node6 = new ArrayList<Integer>() {{add(0);add(6);}};
   
   ArrayList<ArrayList<Integer>> inter1 = new ArrayList<ArrayList<Integer>>(){
     {
         add(node1);
         add(node2);
     }  
   };
   ArrayList<ArrayList<Integer>> inter2 = new ArrayList<ArrayList<Integer>>(){
     {
         add(node3);
         add(node4);
     }  
   };
   ArrayList<ArrayList<Integer>> inter3 = new ArrayList<ArrayList<Integer>>(){
     {
         add(node5);
         add(node6);
     }  
   };
   ArrayList<ArrayList<ArrayList<Integer>>> adj= new ArrayList<ArrayList<ArrayList<Integer>>>(){
       {
           add(inter1); // for 1st node
           add(inter2); // for 2nd node
           add(inter3); // for 3rd node
       }
   };
   int[] res=dijkstra(V,adj,S);
   
   for(int i=0;i<V;i++){
       System.out.print(res[i]+" ");
   }
   System.out.println();
   
   }
}
class name{
    int node;
    int dis;
    public name(int dis,int node){
        this.node = node;
        this.dis = dis;
    }
}

