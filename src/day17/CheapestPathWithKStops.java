package day17;
import java.util.*;
public class CheapestPathWithKStops {
	public static int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<Pair>> al=new ArrayList<>();
        for(int i=0;i<n;i++)
        al.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++)
        {
            al.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0,src,0));
        int[] dist = new int[n]; 
        for(int i = 0;i<n;i++) {
            dist[i] = (int)(1e9); 
        }
        dist[src] = 0;
        
        while(!q.isEmpty())
        {
            int stop=q.peek().first;
            int node=q.peek().second;
            int cost=q.peek().third;
            q.poll();
             if(stop > k) continue;
            for(Pair i:al.get(node))
            {
               int en=i.first;
               int ew=i.second;
               if(cost+ew<dist[en] && stop <= k)
               {
                 dist[en]= cost+ew; 
                 q.add(new Tuple(stop+1,en,dist[en]));
               }
            }
            
        }
         if(dist[dst] == (int)(1e9)) return -1; 
        return dist[dst];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][]= {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
       int n=4;
       int src=0;
       int dst=3;
       int k=1;
       System.out.println("Cheapest Flights Within K Stops is= "+CheapestFLight(n,grid,src,dst,k));
	}
}
class Tuple
{
    int first;
    int second;
    int third;
    public Tuple(int first,int second,int third)
    {
       this.first=first;
       this.second=second;
       this.third=third;
    }
}
class Pair
{
    int first;
    int second;
    public Pair(int first,int second)
    {
       this.first=first;
       this.second=second;
    }
}

