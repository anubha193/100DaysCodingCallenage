package Day3;
import java.util.*;
class  Node
{
	int data;
	Node next;
	Node bottom;
	Node(int data)
	{
		this.data=data;
	}
	
}
public class FlattanALinkedList
{
    Node flatten(Node root)
    {
         if(root == null || root.next == null)
       return root;
       root.next = flatten(root.next);

       root = merge(root, root.next);

     return root;
	}
    Node merge(Node head1,Node head2)
    {
    if(head1==null)return head2;
    if(head2==null)return head1;
    Node a=head1;
    Node b=head2;
    Node head=null,tail=null;
    if(a.data<=b.data)
    {
     head=a;
     tail=a;
     a=a.bottom;
    }
    else
    {
        head=b;
        tail=b;
        b=b.bottom;
    }
    while(a!=null && b!=null)
    {
        if(a.data<=b.data)
        {
         tail.bottom=a;
         tail=a;
         a=a.bottom;
        }
        else
        {
          tail.bottom=b;
          tail=b;
          b=b.bottom;
        }
    }
    if(a==null)tail.bottom=b;
    if(b==null)tail.bottom=a;
    return head;
   } 
    
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
