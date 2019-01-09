import java.util.ArrayList;

public class ChapterTwo {

	public static void main(String[] args) {


	}

	/**
	 * @param head - head of the linked list
	 * Removes the duplicate nodes from the linked lists
	 */
	public void removeDups(Node head){
		Node n = head;
		ArrayList<String> elements = new ArrayList<String>();

		while(n.next!=null){
			if(elements.contains(n.data)){
				n.next = n.next.next;
			}else {
				elements.add(n.data);
			}
		}
	}

	/**
	 * @param head
	 * @param k
	 * Return the kth element from end of the linked list
	 */
	public void returnKth(Node head, int k){
		Node n = head;
		if(n == null){
			System.out.print("Not a valid Linked List");
		}
		else{
			int nodeCount=0;
			int nodeCounter=0;

			while(n.next!= null){
				nodeCount++;
			}
			n= head;
			while(n.next!= null){
				nodeCounter=nodeCounter +1;
				if(nodeCount-nodeCounter+1 == k){
					System.out.println(k+"th element is "+ n.data);
				}
				else{
					n=n.next;
				}
			}		
		}
	}
	
	/**
	 * @param n
	 * @return true/false
	 */
	public boolean deleteMiddle(Node n){
		if(n==null || n.next == null){
			return false;
		}
		Node nextN = n.next;
		n.data = nextN.data;
		n.next = nextN.next;
		return true;
	}
	
	public void partition(String d, Node head){
		Node n = head;
		while(n.next!=null){
			
		}
	}

	/**
	 * @author IceAuror
	 * Describes the properties and behavior of a typical node
	 */
	public class Node {
		Node next = null;
		String data;

		/**
		 * @param d - Data for the node
		 */
		public Node(String d) {
			data = d;
		}

		/**
		 * @param d data to be added to the linked list
		 * Adds a new node to the end of the linked list
		 */
		void appendToTail(String d){
			Node end = new Node(d);
			Node n = this;
			while(n.next != null) {
				n = n.next;
			}
			n.next = end;
		}

		/**
		 * @param head
		 * @param d
		 * @return the head of the linked list
		 * Removes the node from a linked list
		 */
		Node remove(Node head, String d){
			Node n = head;			
			if(n.data == d){
				return head.next;
			}

			while(n.next!=null){
				if (n.next.data == d){
					n.next = n.next.next;
					return head;
				}
				n= n.next;
			}
			return head;
		}
	}
}
