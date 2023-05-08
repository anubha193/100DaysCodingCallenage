  package day20;

public class GfgPotd {
	public static int addMinChar(String str){
		 int len = str.length();
        int start = 0, end = len - 1;
        int res = 0;
        while(start < end) {
            if(str.charAt(start) == str.charAt(end)){ start++; 
                                       end--;
            }
            else {
                res++;
                start = 0;
                end = len - res - 1;
            }
            
        }
        
        return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String str="ABCD";
       System.out.println(addMinChar(str));
       System.out.println(addMinChar("abba"));
	}

}
