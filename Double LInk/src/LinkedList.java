
public class LinkedList {
	private Node Head;
	private int count = 0;
	
	public void addToHead(int value) {
		Node newNode = new Node();
		newNode.setDate(value);
		newNode.setNext(Head);
		Head = newNode;
		count++;
	}
	
	public int removeFromHead() {
		if (count == 0) {
			return null;
		}
		int tmp = head.getData();
		head = head.getNext();
		count--;
		return tmp;
	}
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public void clear() {
		head = null;
		count = 0;
	}
	
	public int size() {
		return count;
	}
	
	public int deleteAfter(int target) {
		Node n = internalSearch(target);
		
		if(n.getNext() == null) {
			return null;
		}
		int rtn = n.getNext().getData();
		n.setNext(n.getNext().getNext());
		return target;
	}
	
	public int countOccurences(int target) {
		int cnt = 0;
		Node tmp = head;
		while(tmp != null) {
			rtn += "<" +tmp.getData() + "> ->";
			tmp = tmp.getNext();
		}
		rtn += "null";
	}
	

	public boolean addAfter(int target, int dataToAdd) {
		Node n = internalSearch(target);
		if (n == null) {
			return false;
		}
		Node newNode = new Node();
		newNode.setDate(dataToAdd);
		newNode.setNext(n.getNext());
		n.setNext(newNode);
		count++;
		return true;
	}
	
	public Node internalSearch(int target) {
		Node tmp = head;
		while(tmp != null) {
			if(tmp.getData() == target) {
				return tmp;
			}
			tmp = tmp.getNext();
		}
		return tmp;
	}
	
	public String toString() {
		String rtn = "";
		if(count == 0) {
			rtn = "<empty>";
		} else {
			Node tmp = head;
			while (tmp != null) {
				rtn += "<" + tmp.getData() + "> -> ";
				tmp = tmp.getNext();
			}
			rtn += "null";
		}
		return rtn;
	}
	
	
	
	
	
	
}
