package day19;
import java.util.*;
public class Potd {
	public static int knightInGeekland(int arr[][], int x, int y){
	int n=arr.length;
    int m=arr[0].length;
    ArrayList<Integer> al=new ArrayList<>();
    int[] delrow={-2,-2,2,2,-1,-1,1,1};
    int[] delcol={-1,1,-1,1,-2,2,-2,2};
    Queue<tuple> q=new LinkedList<>();
    int visit[][]=new int[n][m];
    q.add(new tuple(x,y));
    visit[x][y]=1;
    int sum=0;
    al.add(arr[x][y]);
    while(!q.isEmpty())
    {
        int size=q.size();
        sum=0;
        for(int j=0;j<size;j++)
        {
      int row=q.peek().first;
      int col=q.peek().second;
      q.poll();
      for(int i=0;i<8;i++)
      {
          int newrow=row+delrow[i];
          int newcol=col+delcol[i];
          if(newrow>=0 && newrow<n && newcol>=0 && newcol<m && visit[newrow][newcol]==0)
          {
              sum+=arr[newrow][newcol];
              q.add(new tuple(newrow,newcol));
              visit[newrow][newcol]=1;
          }
      }
       }
       al.add(sum);
    }
   System.out.println(al);
    for(int i=al.size()-1;i>=0;i--)
    {
        if(i+al.get(i)<al.size())
        {
            al.set(i, al.get(i) + al.get(i + al.get(i)));
        }
    }
    System.out.println(al);
    int max=-1;
    int ans=-1;
    for(int i = 0; i < al.size(); i++){
        if(al.get(i) > max){
            max = al.get(i);
            ans = i;
        }
    }
    return ans;
 }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int[][] arr= {{7, 6, 8},{9, 1, 4},
    		{6, 2, 8}};
    		System.out.println(knightInGeekland(arr,2,1));
	}

}
class tuple
{
    int first;
    int second;
    
    public tuple(int first,int second){
        this.first=first;
        this.second=second;
    
    }
}
