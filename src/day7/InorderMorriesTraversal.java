package day7;
import java.util.*;
class Node
{
	int data;
	Node left;
	Node right;
	public Node(int data)
	{
		this.data=data;
	}
};

public class InorderMorriesTraversal {
	   static ArrayList<Integer> inorder(Node root)
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
					curr=curr.left;
				 }
				 else
				 {
					pre.right=null;
					al.add(curr.data);
					curr=curr.right;
				 }
			  }
		  }
		  return al;
	   }
       public static void main(String[] args)
       {
    	   Node root=new Node(1);
   		root.left=new Node(2);
   		root.right=new Node(3);
   		root.left.left=new Node(11);
   		root.left.right=new Node(12);
   		root.right.left=new Node(20);
   		root.right.right=new Node(21);
   		System.out.println("Inorder by Morris Traversal=");
   		System.out.println(inorder(root));
       }
}
