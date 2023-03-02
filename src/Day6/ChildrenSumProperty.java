package Day6;
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
}
public class ChildrenSumProperty {
       static void sumProperty(Node root)
       {
    	   if(root==null)return;
    	   int ans=0;
    	   if(root.left!=null)ans+=root.left.data;
    	   if(root.right!=null)ans+=root.right.data;
    	   if(root.data<=ans)
    	   {
    		   root.data=ans;
    	   }
    	   else
    	   {
    		   if(root.left!=null)root.left.data=root.data;
    		   if(root.right!=null)root.right.data=root.data;
    	   }
    	
    	   sumProperty(root.left);
    	   sumProperty(root.right);
    	   int curr=0;
    	   if(root.left!=null)curr+=root.left.data;
    	   if(root.right!=null)curr+=root.right.data;
    	   if(root.left!=null ||root.right!=null)root.data=curr;
       }
       static List<List<Integer>> levelOrder(Node root) {
           List<List<Integer>> al=new LinkedList<List<Integer>>();
          Queue<Node> q = new LinkedList<Node>();
            if(root==null)return al;
            q.offer(root);
            while(!q.isEmpty())
            {
                List<Integer> res=new LinkedList<>();
                int n=q.size();
                for(int i=0;i<n;i++)
                {
                    if(q.peek().left!=null)q.offer(q.peek().left);
                    if(q.peek().right!=null)q.offer(q.peek().right);
                    res.add(q.poll().data);
                }
                al.add(res);
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
		System.out.println("Make the tree that follow the children sum property=");
		sumProperty(root);
		System.out.println(levelOrder(root));
	}

}
