package day19;
import java.util.*;
public class leetcodepotd{
	    public static int[] successfulPairs(int[] spells, int[] potions, long success) {
	       int n= spells.length;
	       int m= potions.length;
	       Arrays.sort(potions);
	       int[] pair=new int[n];
	      for (int i = 0; i < n; i++) { // n log m
			int left = 0, right = m;
	         while (left < right) {
				int mid = left + (right - left) / 2;
	            if ((long) spells[i] * (long) potions[mid] >= success)
					right = mid;
				else
					left = mid + 1;
			}

			pair[i] = m - left;
		}

		return pair;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] spells = {5,1,3}; 
		int[] potions = {1,2,3,4,5};
		int success = 7;
		int temp[]=successfulPairs(spells,potions,success);
		for(int i=0;i<temp.length;i++)
		{
			System.out.print(temp[i]+" ");
		}
				}

}
