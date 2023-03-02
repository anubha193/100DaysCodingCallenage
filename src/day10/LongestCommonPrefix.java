package day10;

public class LongestCommonPrefix {
        static String result(String str[])
        {
        	String ans="";
        	for(int i=0;i<str[0].length();i++)
        	{
        		char ch=str[0].charAt(i);
        		boolean ismatch=true;
        		for(int j=1;j<str.length;j++)
        		{
        			if(str[j].length()<i || ch!=str[j].charAt(i))
        			{
        				ismatch=false;
        				break;
        			}
        		}
        		if(ismatch==false)
        			break;
        		else
        			ans+=ch;
        	}
        	return ans;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String str[]= {"apple","app","appr"};
        System.out.println(result(str));
	}

}
