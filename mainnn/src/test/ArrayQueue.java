package test;

import mainnn.Plane;

public class ArrayQueue {

	public static final int INITIAL_SIZE = 1000;
	private int[] queue; // array queue
	private int count; // create count
	private int head, tail;
	
	public ArrayQueue() {
		count = 0;
		head = 0;
		tail = 0;
		queue = new int[INITIAL_SIZE]; // set an initial size
	}
	
	public boolean isFull() {
		if (count == queue.length) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		return(count == 0);
	}
	
	public int getSize() {
		return count;
	}
	
	public void add(int value) { 
		if (isFull()) {
			int[] newqueue = new int[queue.length + INITIAL_SIZE];
			// copy queue to new queue
			for(int i=0; i < count; i++) {
				newqueue[i] = queue[i];
			}
			queue = newqueue;
		}
		queue[tail++] = value;
		count++;
	}
	
	public void remove() {
        // if queue is empty
        if (head == tail) {
            return;
        }else {
            for (int i = 0; i < tail - 1; i++) {
                queue[i] = queue[i + 1];
            }
 
            // store 0 at rear indicating there's no element
            if (tail < INITIAL_SIZE)
                queue[tail] = 0;
 
            // decrement rear
            tail--;
        }
        
        count--;
        return;
	}
	
	public void removeTarget(int target) {
		if (head == tail) {
            System.out.printf("\nQueue is empty\n");
            return;
        }else {
            for (int i = target; i < tail - 1; i++) {
                queue[i] = queue[i + 1];
            }
            
            if (tail < INITIAL_SIZE)
                queue[tail] = 0;
 
            // decrement tail
            tail--;
        }
        
        count--;
        return;
	}
	
	public int getNext(int target) {
		int rtn;
		rtn = queue[target];
		return rtn;
	}
	
	public String toString() {
		String rtn = "ArrayQueue count: " + count + "\n";
		if(count == 0) {
			rtn += "Queue is empty :(\n";
		}
		for(int i=0; i < count; i++) {
			rtn += "ArrayQueue[" + i + "] = " + queue[i] + "\n";
		}
		return rtn;
	}
	
	
}
