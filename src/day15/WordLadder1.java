package day15;
import java.util.*;
class Pair {
    String first;
    int second;
    Pair(String first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class WordLadder1 {
	 public static int wordLadderLength(String startWord, String targetWord, String[] wordList) {
	        Queue < Pair > q = new LinkedList < > ();
	        q.add(new Pair(startWord, 1));
	        Set < String > st = new HashSet < String > ();
	        int len = wordList.length;
	        for (int i = 0; i < len; i++) {
	            st.add(wordList[i]);
	        }
	        st.remove(startWord);
	        while (!q.isEmpty()) {
	            String word = q.peek().first;
	            int steps = q.peek().second;
	            q.remove();
	            if (word.equals(targetWord) == true) return steps;
	            for (int i = 0; i < word.length(); i++) {
	                for (char ch = 'a'; ch <= 'z'; ch++) {
	                    char replacedCharArray[] = word.toCharArray();
	                    replacedCharArray[i] = ch;
	                    String replacedWord = new String(replacedCharArray);
	                    if (st.contains(replacedWord) == true) {
	                        st.remove(replacedWord);
	                        q.add(new Pair(replacedWord, steps + 1));
	                    }
	                }

	            }
	        }
	      
	        return 0;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String startWord = "der", targetWord = "dfs";
	        String[] wordList = {
	            "des",
	            "der",
	            "dfr",
	            "dgt",
	            "dfs"
	        };

	        
	        int ans = wordLadderLength(startWord, targetWord, wordList);

	        System.out.print(ans);

	        System.out.println();
	}

}
