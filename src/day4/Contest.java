package day4;
import java.util.*;
public class Contest {
	 public static void distinctAverages(int[] nums) {
	      ArrayList<Integer> al=new ArrayList<>();
	        for(int i=0;i<nums.length;i++)
	            al.add(nums[i]);
	        Collections.sort(al);
	        ArrayList<Double> res=new ArrayList<>();
	        while(al.size()!=0)
	        {
	            double sum=(al.get(0)+al.get(al.size()-1))/2.0;
	            res.add(sum);
	            al.remove(al.get(0));
	            al.remove(al.get(al.size()-1));
	        }
	        HashSet<Double> hs=new HashSet<>();
	        for(int i=0;i<res.size();i++)
	        	hs.add(res.get(i));
	        System.out.println(hs.size());
	    
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int nums[]= {1,100};
        distinctAverages(nums);
	}

}
