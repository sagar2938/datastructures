package LinkedLists;

public class Operations {

	/**
	 * @param args
	 */static Node head=null;
	 static int a=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[]={1,2,3,4,5,6,7,8,9,10};
		head=createLinkedList(head, arr);
		System.out.println("a : "+a);
		System.out.println("the new head is : "+head);
		displayLinkedList(head);
		System.out.println("reversing a linked list");
		Node newHead=reverseLinkedList(head);
		displayLinkedList(newHead);
		Node loopHead=new Node(1);
		Node one =new Node(2);
		Node two=new Node(3);
		Node four=new Node(5);
		Node six=new Node(6);
		loopHead.next=one;
		one.next=two;
		two.next=four;
		four.next=six;
		six.next=two;
		//displayLinkedList(loopHead);
		int data=removeCycle(loopHead);
		System.out.println();
		System.out.println("checking for the loop in linked list");
		displayLinkedList(loopHead);
		System.out.println();
		if(data==-1){
			System.out.println("no loop found in linked list");
		}else{
			System.out.println("loop found at "+data);
		}
		
		
	}
	public static Node createLinkedList(Node head,int[]arr){
		System.out.println("create linked list is invoked");
		Node temp=head;
		Operations.a=Operations.a+10;
		for(int i=0;i<arr.length;i++){
			if(head==null){
				System.out.println("head is null");
				head=new Node(i);
				System.out.println(head);
				temp=head;
			}else{
				//System.out.println("head is not null  "+i);
				temp.next=new Node(i);
				temp=temp.next;
			}
		}
		System.out.println("before coming out");
		System.out.println(head);
		return head;
	}
	public static void displayLinkedList(Node head){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data+"  ");
			temp=temp.next;
		}
	}
	public static Node reverseLinkedList(Node head){
		System.out.println("recieved head "+head);
		Node tempHead=head;
		Node prev=null;
		//prev.next=null;
		Node tail=prev;
		//tempHead=tempHead.next;
		while(tempHead!=null){
			Node temp=tempHead.next;
			Node current =tempHead;
			current.next=prev;
			prev=current;
			System.out.println(prev.data);
			System.out.println(tempHead);
			tempHead=temp;
			System.out.println("count");
		}
	//	tail.next=null;
		return prev;
	}
	public static int removeCycle(Node head){
		Node p=head;
		Node q=head;
		boolean loopFound=false;
		while(p!=null && q!=null && q.next!=null){
			p=p.next;
			q=q.next.next;
			if(p==q){
				loopFound=true;
				break;
			}
		}
		if(loopFound){
			Node loopStart=findLoopStart(p, head);
			Node next=loopStart.next;
			while(next.next!=loopStart){
				next=next.next;
			}
			next.next=null;
			return loopStart.data;
		}else{
			return -1;
		}
		
	}
	public static Node findLoopStart(Node p,Node head){
		Node q=head;
		while(p!=q){
			p=p.next;
			q=q.next;
		}
		return p;
	}
}
