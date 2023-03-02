package day7;
import java.util.*;
public class SearchInBST {
      static boolean search(Node root,int k)
      {
    	  if(root == null) return false;
          if(root.data == k){
              return true;
          }
          else{
              return k<root.data? search(root.left,k):search(root.right,k);
          }
      }
     
     
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Node root=new Node(40);
	   		root.left=new Node(30);
	   		root.right=new Node(50);
	   		root.left.left=new Node(20);
	   		root.left.right=new Node(35);
	   		root.right.left=new Node(45);
	   		root.right.right=new Node(60);
	   		if(search(root,50))
	   			System.out.println("present");
	   		else
	   			System.out.println("not present");
	   		

	}

}
