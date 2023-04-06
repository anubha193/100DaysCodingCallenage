package day18;
import java.util.*;
public class BellmanFord {
	static int[] bellman_ford(int V,int[][] al, int S) {
        // Write your code here
        int dis[]=new int[V];
           Arrays.fill(dis,(int)1e8);
         dis[S]=0;
          for(int i=0;i<V-1;i++)
                  {
                  for(int j=0;j<al.length;j++)
                 {
                  int u=al[j][0];
                  int v=al[j][1];
                  int w=al[j][2];
  
                if(dis[u]!=1e8 && (dis[u]+w)<dis[v])
                      dis[v]=w+dis[u];

            }

        }
         for(int i=0;i<al.length;i++)
            {
        	 int u=al[i][0];
             int v=al[i][1];
             int w=al[i][2];
               if(dis[u]!=(int)10e8 && (dis[u]+w)<dis[v])
                 return new int[]{-1};
            }
            return dis;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] al= {{0,1,9}};
		int s=0;
		int v=2;
		int ans[]=bellman_ford(v,al,s);
		for(int i=0;i<ans.length;i++)
			System.out.print(ans[i]+" ");

	}

}
