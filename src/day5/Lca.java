package day5;

public class Lca {
      static int lowest(Node root,int a,int b)
      {
    	 if(root==null )return 0;
    	 else if(root.data==a)return a;
    	 else if(root.data==b)return b;
    	 int left=lowest(root.left,a,b);
    	 int right=lowest(root.right,a,b);
    	 if(left==0)return right;
    	 else if(right==0)return 0;
    	 else return root.data;
    	 
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
		System.out.println("The Lowest Common Ancestor is="+lowest(root,21,11));
	}

}
