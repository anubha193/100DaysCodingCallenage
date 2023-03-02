package day5;
import java.util.*;
 class Node
 {
	 int data;
	 Node left;
	 Node right;
	 Node(int data)
	 {
		 this.data=data;
	 }
	 
 }
public class MaximumPathSum {
	static int maximumpath(Node root,int[] max )
    {
  	  if(root==null)return 0;
  	  int lh=Math.max(0,maximumpath(root.left,max));
  	  int rh=Math.max (0,maximumpath(root.right,max));
  	  max[0]=Math.max(max[0], lh+rh+root.data);
  	  return root.data+Math.max(lh, rh);
  	  
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
		int max[]=new int[1];
		 max[0] = Integer.MIN_VALUE;
        System.out.println("the maximum path sum is= "+maximumpath(root,max));
        
	}

}
