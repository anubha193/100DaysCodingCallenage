package day8;
class Node
{
	Node left,right;
	int data;
	Node(int data)
	{
	this.data=data;
	}
}
public class InorderSuccessorANdPredecesot {
          static Node pre(Node root,Node key)
          {
        	 Node p=null;
        	 Node temp=root;
        	 while(temp!=null)
        	 {
        		 if(temp.data>key.data){
                     temp = temp.left;
                 }
                 else{
                	 p=temp;
                     temp = temp.right;
                 }
        	 }
        	 return p;
          }
          static Node succ(Node root,Node Key)
          {
        	  Node p=null;
         	 Node temp=root;
         	 while(temp!=null)
         	 {
         		 if(temp.data>Key.data){
         			 p=temp;
                      temp = temp.left;
                  }
                  else{
                 	
                      temp = temp.right;
                  }
         	 }
         	 return p;
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
   		System.out.println("The is inorder successor is"+ pre(root,root.right.right).data);
   		System.out.println("the inorder predecessor is"+succ(root,root.left.left).data);
	}

}
