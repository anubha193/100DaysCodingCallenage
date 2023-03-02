package Day6;
import java.util.*;
public class DistanceByK {
	    static void foundparent(Node root,Map<Node,Node> parent)
	    {
	    	Queue<Node> q=new LinkedList<>();
	    	q.offer(root);
	    	while(!q.isEmpty())
	    	{
	    		Node curr=q.poll();
	    		if(curr.left!=null)
	    		{
	    			parent.put(curr.left, curr);
	    			q.offer(curr.left);
	    		}
	    		if(curr.right!=null)
	    		{
	    			parent.put(curr.right, curr);
	    			q.offer(curr.right);
	    		}
	  }
	    	
	    }
        static List<Integer> result(Node root,Node target,int k)
        {
         Map<Node,Node> parent=new HashMap<>();
         foundparent(root, parent);
         Queue<Node> q=new LinkedList<Node>();
         Map<Node,Boolean> visit=new HashMap<>();
         q.offer(target);
         visit.put(target,true);
         int curr=0;
         while(!q.isEmpty())
         {
        	 int size=q.size();
        	 if(curr==k)
        		 break;
        	 curr++;
        	 for(int i=0;i<size;i++)
        	 {
        		 Node temp=q.poll();
        		 if(temp.left!=null && visit.get(temp.left)==null)
        		 {
        			 q.offer(temp.left);
        			 visit.put(temp.left, true);
        			}
        		 if(temp.right!=null && visit.get(temp.right)==null)
        		 {
        			
        			 q.offer(temp.right);
        			 visit.put(temp.right, true);
        		 }
        		 if(parent.get(temp)!=null && visit.get(parent.get(temp))==null)
        		 {
        			 q.offer(parent.get(temp));
        			 visit.put(parent.get(temp), true);
        			
        		 }
        	 }
        	 
         }
         List<Integer> al=new ArrayList<>();
    	 while(!q.isEmpty())
    	 {
    		 Node c=q.poll();
    		 al.add(c.data);
    		
    	 }
    	 return al;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root=new Node(3);
		root.left=new Node(5);
		root.right=new Node(1);
		root.left.left=new Node(6);
		root.left.right=new Node(2);
		root.left.right.left=new Node(7);
		root.left.right.right=new Node(4);
		root.right.right=new Node(8);
		root.right.right=new Node(0);
		Node target=root.left;
		System.out.println(result(root,target,2));
	}

}
