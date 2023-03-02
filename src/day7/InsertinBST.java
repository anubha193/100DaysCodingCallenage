package day7;

public class InsertinBST {
	 public Node insertIntoBST(Node root, int val) {
	        if(root==null)
	        {    
	        Node node=new Node(val);
	            return node;
	            }
	         if(root.data>val)

	        root.left=insertIntoBST(root.left,val);

	        if(root.data<val)

	        root.right=insertIntoBST(root.right,val);

	        return root;
	        
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

	}

}
