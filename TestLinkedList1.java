class Node {
	private Node next;
	private String data;

	public Node(String data) {
		this.data = data;
	}

	public String data() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node next() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public String toString() {
		return this.data;
	}
}

class MyLinkedList {
	private Node head;

	public MyLinkedList() {
		this.head = new Node("head");
	}

	public Node head() {
		return head;
	}

	public void appendIntoTail(Node node) {
		Node current = head;
		while (current.next() != null) {
			current = current.next();
		}
		current.setNext(node);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node current = head.next();
		while (current != null) {
			sb.append(current).append("-->");
			current = current.next();
		}
		sb.delete(sb.length() - 3, sb.length());
		return sb.toString();
	}
}

public class TestLinkedList1 {
	public static void main(String args[]) {
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.appendIntoTail(new Node("101"));
		linkedList.appendIntoTail(new Node("201"));
		linkedList.appendIntoTail(new Node("301"));
		linkedList.appendIntoTail(new Node("401"));
		linkedList.appendIntoTail(new Node("201"));
		System.out.println("Linked List : " + linkedList);

	}
}
