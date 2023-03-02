package Day3;
class  Node
{
	int data;
	Node next;
	Node(int data)
	{
		this.data=data;
	}
	
}
public class QueueImplementation {
	static Node front;
	static Node rear;
     static void enqueue(int data)
     {
    	Node newnode=new Node(data);
    	if(front==null)
    	{
    	front=newnode;
    	rear=newnode;
    	}
    	else
    	{
    		rear.next=newnode;
    		rear=newnode;
    	}
     }
     static int dequeue()
     {
    	if(front==null)
    		return -1;
    	else
    	{
    		int result=front.data;
    		front=front.next;
    		return result;
    	}
     }
	public static void main(String[] args) {
		QueueImplementation q = new QueueImplementation();
	        q.enqueue(10);
	        q.enqueue(20);
	        q.dequeue();
	        q.dequeue();
	        q.enqueue(30);
	        q.enqueue(40);
	        q.enqueue(50);
	        q.dequeue();
	        System.out.println("Linked List representation=");
	        System.out.println("Queue Front : " + q.front.data);
	        System.out.println("Queue Rear : " + q.rear.data);

	}

}
