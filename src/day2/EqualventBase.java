package day2;

public class EqualventBase {
	 static String result (int n, int m)
	    {
	         for(int i =2 ; i<32;i++){
             String a = Integer.toString(n,i);
             System.out.println(a);
                if(a.length()==m){
                 return "Yes";
                    }
	         }
           return "No";
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int n =8;
         int m=2;
         System.out.println(result(n,m));
	}

}
