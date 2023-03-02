package day8;

public class RecoverBST {
	 static Node first,prev,last,mid;
	    public void recoverTree(Node root) {
	       first=last=mid=null;
	        prev=new Node(Integer.MIN_VALUE);
	        inorder(root);
	        if(first!=null && last!=null)
	        {
	          int temp=first.data;
	            first.data=last.data;
	            last.data=temp;
	        }
	        else if(first!=null && mid!=null)
	        {
	            int temp=first.data;
	            first.data=mid.data;
	            mid.data=temp; 
	        }
	    }
	    static void inorder(Node root)
	    {
	        if(root==null)return;
	        inorder(root.left);
	        if(prev!=null && prev.data>root.data)
	        {
	            if(first==null)
	            {
	               first=prev;
	                mid=root;
	            }
	            else
	            {
	             last=root;   
	            }
	            
	        }
	        prev=root;
	        inorder(root.right);
	        
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
