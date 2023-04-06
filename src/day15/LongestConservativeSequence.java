package day15;
import java.util.HashSet;
public class LongestConservativeSequence {
	public static int longestConsecutive(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);
        }
        int longSeq=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(!hs.contains(nums[i]-1)){
                int num=nums[i]+1;
                count=1;
                while(hs.contains(num)){
                    num+=1;
                    count++;
                }
                longSeq=Math.max(longSeq,count);
            }
        }
        return longSeq;
    }
	public static void main(String[] args) {
		int[] arr= {100,4,200,1,3,2};
		System.out.println("The longest conservative subsequence is="+longestConsecutive(arr));
}
}
