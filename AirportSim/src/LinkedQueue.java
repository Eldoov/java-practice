public class LinkedQueue<T> {

	private Node<T> head;
	private Node<T> tail;
	int count;
	
	public LinkedQueue() {
		head = tail = null;
		count = 0;
	}
	
	public boolean add(T data) {
		// Allocate a new node and fill it in.
		Node<T> newNode = new Node<T>();
		newNode.setData(data);
		
		// Special case if list is empty
		if (count == 0) {
			head = tail = newNode;
			count = 1;
			return true;
		}
		
		// General case
		tail.setNext(newNode);
		tail = newNode;
		count++;
		
		return true;
	}

	public T remove() {
		
		if (isEmpty()) {
			return null;
		}
		
		T rtn = head.getData();
		
		head = head.getNext();
		count--;
		
		// If removing this element made the queue empty
		// we need to make sure head and tail are both null
		if (count == 0) {
			head = tail = null;
			
		}
		return rtn;
	}
	
    private Node<T> internalSearch(T data) {
        Node<T> tmp = head;
        while(tmp != null) {
            if (tmp.getData().equals(data)) {
                return tmp;
            }

            tmp = tmp.getNext();
        }

        return null;
    }
    
    public void addNum(int i, int num) {
    	
    }
    
    public T delete(T target) {
        // Empty List
        if (count == 0) {
            return null;
        }

        Node<T> targetNode = internalSearch(target);
        // Target does not exist
        if (targetNode == null) {
            return null;
        }

        T rtn = targetNode.getData();

        // Special case "Only Node"
        if (count == 1) {
            count = 0;
            head = tail = null;
            return rtn;
        }

        // Handle the head case
        if (targetNode == head) {
            head = head.getNext();
            head.setPrev(null);
            count--;
            return rtn;
        }

        // Handle tail case
        if (targetNode == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
            count--;
            return rtn;
        }

        // General case
        // Handle the previous node
        targetNode.getPrev().setNext(targetNode.getNext());

        // Handle the next node
        targetNode.getNext().setPrev(targetNode.getPrev());
        count--;
        return rtn;
    }

	public boolean isEmpty() {
		return (count == 0);
	}

	public boolean isFull() {
		return false;
	}

	public T queueHead() {
		if (isEmpty()) {
			return null;
		}
		return head.getData();
	}

	public void clear() {
		head = tail = null;
		count = 0;
	}

	public int size() {
		return count;
	}

	public String toString() {
		if (isEmpty()) {
			return "<Empty>";
		}
		
		String rtn = "";
		Node<T> tmp = head;
		while(tmp != null) {
			if (tmp == head) {
				rtn += "Head -> ";
			} else {
				rtn += "        ";
			}
			rtn += tmp.getData() + "\n";
			tmp = tmp.getNext();
		}
		return rtn;
	}
}
