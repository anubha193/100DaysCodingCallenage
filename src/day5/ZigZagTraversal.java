package day5;
import java.util.*;
public class ZigZagTraversal {
     static  List<List<Integer>> zigzag(Node root)
     {
    	 List<List<Integer>> al=new LinkedList<List<Integer>>();
         Queue<Node> q = new LinkedList<Node>();
            if (root == null) return al;
           q.offer(root);
           boolean flag=true;
           while(!q.isEmpty())
           {
               LinkedList<Integer> res=new LinkedList<>();
               int n=q.size();
                
               for(int i=0;i<n;i++)
               {
                  
                   if(q.peek().left!=null)q.offer(q.peek().left);
                   if(q.peek().right!=null)q.offer(q.peek().right);
                   res.add(q.poll().data);
               }
              
               if(flag==false)
                 Collections.reverse(res);
               al.add(res);
                  if(flag==true)flag=false;
                   else
                       flag=true;     
               
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
		System.out.println("Zigzag Traversal of tree=");
		System.out.println(zigzag(root));
	}

}
