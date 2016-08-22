package main;


public class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
	
	public static Node deleteSkipNodes(Node head) {
		if(head == null) 
			return null;
		
		// Set previous and next nodes
		Node previous = head;
		Node current = head.next;
		
		// prev and now will be set to the same node when we're done deleting, so check if prev != now
		while(previous != null && current != null && previous != current) {
			
			// set prev.next to skip the now node
			previous.next = current.next;
			
			// Delete now node
			current = null;
			
			// Update the prev and now nodes
			previous = previous.next;
			if(previous != null) {
				current = previous.next;
			}
		}
		previous = null;
		return current;
	}
		
		


	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n1;
		
		Node n = deleteSkipNodes(n1);	
		System.out.println(n.data); //Should print 3
	}

}
