
public class LinkedQueue<T> {

	private Node<T> head;
	private Node<T> tail;
	int count;
	int size = -1;
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public LinkedQueue() {
		head = tail = null;
		count = 0;
	}
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public boolean isFull() {
		return (count == size);
	}
	
	public int size() {
		return count;
	}
	
	public void add (T item) {
		Node<T> newNode =  new Node<T>();
		newNode.setData(item);
		
		if (isEmpty()) {
			head = tail = newNode;
			count = 1;
		}
		
		if (isFull()) {
			System.out.println("Oven is full.");
		}
		
		tail.setNext(newNode);
		tail = newNode;
		count++;
	}
	
	public T remove() {
		if(isEmpty()) {
			return null;
		}
		
		T rtn = head.getData();
		head = head.getNext();
		count--;
		
		if(count == 0) {
			head = tail = null;
		}
		
		return rtn;
	}

}
