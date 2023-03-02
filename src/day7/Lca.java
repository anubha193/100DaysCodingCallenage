package day7;

public class Lca {
       static Node LcaTree(Node root,int p,int q)
       {
    	   if(root==null)return null;
    	   int curr=root.data;
    	   if(curr>p && curr>q)
    		   LcaTree(root.left,p,q);
    	   if(curr<p && curr<q)
    		   LcaTree(root.right,p,q);
    	   return root;
       }
       static Node foundright(Node root)
       {
    	   if(root.right==null)return root;
    	   return foundright(root.right);
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
       Node curr=LcaTree(root,30,50);
       System.out.println(curr.data);
       System.out.println(foundright(root).data);
	}

}
