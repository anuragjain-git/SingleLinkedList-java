
import java.util.*;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class sortedInsert {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Node curr = null;
		Node head = null;

		char ch = 'y';
		while (ch == 'y') {
			System.out.print("Enter an integer value to insert: ");
			if (head == null) {
				head = new Node(sc.nextInt());
				curr = head;
			} else {
				curr.next = new Node(sc.nextInt());
				curr = curr.next;

			}
			System.out.print("Enter more number ? Y/N : ");
			ch = sc.next().charAt(0);
		}

		display(head);
		System.out.println();
		System.out.print("Enter element to Sortedinsert: ");
		insert(head, sc.nextInt());

		display(head);
		System.out.println();

		System.out.print("Enter value to search :");
		System.out.println(searchList(head, sc.nextInt()));
		head = deleteHead(head);
		display(head);

		System.out.println();
		System.out.print("Enter a value to delete:");
		head = deleteAnyNode(head, sc.nextInt());
		display(head);

		System.out.println();
		head = deleteSLL(head);
		display(head);

		System.out.println();
		head = reverse(head);
		display(head);

		System.out.println();
		head = reverseRecursive(head, null);
	}

	public static void insert(Node temp, int value) {
		Node newNode = new Node(value);
		Node curr = temp;
		if (curr == null || curr.data > value) {
			newNode.next = temp;
			temp = newNode;
			return;
		}
		while (curr.next != null && curr.next.data < value) {
			curr = curr.next;
		}
		newNode.next = curr.next;
		curr.next = newNode;

	}

	public static void display(Node p) {
		while (p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
	}

	public static boolean searchList(Node head, int value) {
		Node temp = head;
		while (temp != null) {
			if (temp.data == value)
				return true;
			temp = temp.next;
		}
		return false;
	}

	public static Node deleteHead(Node temp) {
		if (temp != null) {
			return temp.next;
		}
		return null;
	}

	public static Node deleteAnyNode(Node temp, int delValue) {
		if (temp == null)
			return null;

		if (delValue == temp.data)
			return temp.next;

		while (temp.next != null) {
			if (temp.next.data == delValue) {
				temp.next = temp.next.next;
			}
		}
		return temp;
	}

//	public static Node deleteAllOcurrance() {}

	public static Node deleteSLL(Node temp) {
		return null;
	}

	public static Node reverse(Node temp) {
		Node curr = temp;
		Node next = null;
		Node prev = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	public static Node reverseRecursive(Node currNode, Node nextNode) {
		Node ret;
		if (currNode == null)
			return null;
		if (currNode.next == null) {
			currNode.next = nextNode;
			return currNode;
		}
		ret = reverseRecursive(currNode.next, currNode);
		currNode.next = nextNode;
		return ret;
	}
}
