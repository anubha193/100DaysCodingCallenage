package Day6;
import java.util.*;
public class Serilize {
      static String seriel(Node root)
      {
    	  Queue<Node> q=new LinkedList<>();
    	  String str="";
    	  if(root==null)return str;
    	  q.offer(root);
    	  while(!q.isEmpty())
    	  {
    		Node curr=q.poll();
    		if(curr==null)
    		{
    			str+="# ";
    			continue;
    		}
    		str+=curr.data+" ";
    		q.offer(curr.left);
    		q.offer(curr.right);
    	  }
    	  return str;
      }
     static Node deserial(String data)
     {
    	 if (data == "") return null;
         Queue<Node> q = new LinkedList<>();
         String[] values = data.split(" ");
         
         Node root = new Node(Integer.parseInt(values[0]));
         q.add(root);
         for (int i = 1; i < values.length; i++) {
             Node parent = q.poll();
             if (!values[i].equals("#")) {
                 Node left = new Node(Integer.parseInt(values[i]));
                 parent.left = left;
                 q.add(left);
             }
             if (!values[++i].equals("#")) {
                 Node right = new Node(Integer.parseInt(values[i]));
                 parent.right = right;
                 q.add(right);
             }
         }
         return root; 
     }
     public static List<List<Integer>> levelOrder(Node root) {
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
		System.out.println("Tree before serialize=");
		System.out.println(levelOrder(root));
		System.out.println("Serialization opertion");
		String str=seriel(root);
		System.out.println(seriel(root));
		Node temp=deserial(str);
		System.out.println("Tree after deserilaization");
		System.out.println(levelOrder(temp));
	}

}
