package day17;
import java.util.*;
public class NumberOfWaysToArriveDestination {
	 static int countPaths(int n, List<List<Integer>> grid) {
	      ArrayList < ArrayList < Pair >> al = new ArrayList < > ();
	        for (int i = 0; i < n; i++) {
	            al.add(new ArrayList< >());
	        }
	        int m =grid.size();
	        for (int i = 0; i < m; i++) {
	            al.get(grid.get(i).get(0)).add(new Pair(grid.get(i).get(1), grid.get(i).get(2)));
	            al.get(grid.get(i).get(1)).add(new Pair(grid.get(i).get(0), grid.get(i).get(2)));
	        } 
	        PriorityQueue < Pair > q = new PriorityQueue < Pair > ((x, y) -> x.first - y.first);
	        int[] dis = new int[n];
	        int[] ways = new int[n];
	       Arrays.fill(dis, (int) 1e9);
	       Arrays.fill(ways,0);
	        dis[0] = 0;
	        ways[0] = 1;
	        q.add(new Pair(0, 0));
	        int mod = (int)(1e9 + 7);
	       while (q.size() != 0) {
	            int dist = q.peek().first;
	            int node = q.peek().second;
	            q.remove();
	          for (Pair it : al.get(node)) {
	                int en = it.first;
	                int ew = it.second;
	                if (dist + ew < dis[en]) {
	                    dis[en] = dist + ew;
	                    q.add(new Pair(dist + ew, en));
	                    ways[en] = ways[node];
	                } 
	                    else if (dist + ew == dis[en]) {
	                    ways[en] = (ways[en] + ways[node]) % mod;
	                }
	            }
	        }
	        
	         return ways[n-1] % mod;
	    }
	public static void main(String[] args) {
		int n=7;
		List<List<Integer>> grid=new ArrayList<>();
		{
			{
				    grid.add(new ArrayList<Integer>(Arrays.asList(0, 6, 7)));
	                grid.add(new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
	                grid.add(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
	                grid.add(new ArrayList<Integer>(Arrays.asList(1, 3, 3)));
	                grid.add(new ArrayList<Integer>(Arrays.asList(6, 3, 3)));
	                grid.add(new ArrayList<Integer>(Arrays.asList(3, 5, 1)));
	                grid.add(new ArrayList<Integer>(Arrays.asList(6, 5, 1)));
	                grid.add(new ArrayList<Integer>(Arrays.asList(2, 5, 1)));
	                grid.add(new ArrayList<Integer>(Arrays.asList(0, 4, 5)));
	                grid.add(new ArrayList<Integer>(Arrays.asList(4, 6, 2)));
			}
		}
		System.out.println(" the number of ways to arrive destination is= "+countPaths(n,grid));

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

