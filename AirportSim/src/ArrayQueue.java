import java.util.NoSuchElementException;
public class ArrayQueue<E> {
	
	private Object[] queue;
	private int count;
	private int head;
	private int tail;
	private int size;
	
	public ArrayQueue(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("Illegal Input.");
		}
		size = capacity;
		head = 0;
		tail = 0;
		count = 0;
		queue = new Object[size];
	}
	
	public void add(E plane) {
		
		ensureCapacity();
		
		queue[tail++] = plane;
		count++;
		
	}
	
	public Object remove(E plane) {
		
		if(isEmpty()) {
			return null;
		}
		
		head++; // starting from the next plane to "remove" the former plane
		
		count--;
		return null;
	}
	
	
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public void ensureCapacity() {
		if (count >= size | tail >= size) {
			size = (size * 2) + 1;  // size for new array
			Object newQueue[] = new Object[size];  // creates an new array

			int j=0;  
			for (int i=head; i<tail; i++) {  // loop through old array, copy stuff to new array
				newQueue[j++] = queue[i]; 
			}  
			head = 0; 
			tail = count;  

			queue = newQueue;  
		} 

	}  
	
	public Object setPlane(E planeID, E EntryTime, E Priority) {
		this.planeID = planeID;
		this.
		return null;
	}
	
	

}
