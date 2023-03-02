package day7;
import java.util.*;
public class PreorderMorisTraversal {
       static ArrayList<Integer> preorder(Node root)
       {
    	   ArrayList<Integer> al=new ArrayList<>();
 		  Node curr=root;
 		  while(curr!=null)
 		  {
 			  if(curr.left==null)
 			  {
 				al.add(curr.data);
 				curr=curr.right;
 			  }
 			  else
 			  {
 				 Node pre=curr.left;
 				 while(pre.right!=null && pre.right!=curr)
 				 {
 					 pre=pre.right;
 				 }
 				 if(pre.right==null)
 				 {
 					pre.right=curr; 
 					al.add(curr.data);
 					curr=curr.left;
 				 }
 				 else
 				 {
 					pre.right=null;
 					
 					curr=curr.right;
 				 }
 			  }
 		  }
 		  return al;
       }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Node root=new Node(1);
	   		root.left=new Node(2);
	   		root.right=new Node(3);
	   		root.left.left=new Node(11);
	   		root.left.right=new Node(12);
	   		root.right.left=new Node(20);
	   		root.right.right=new Node(21);
	   		System.out.println("Preorder by Morris Traversal=");
	   		System.out.println(preorder(root));

	}

}
