/*
public class PriorityQueue {
	
	private int MAX;
	private int[] arr;
	private int manyItems;
	
	public PriorityQueue(int cap) {
		MAX = cap;
		arr = new int[MAX];
		manyItems = 0;
	}
	
	public void insert(int val) {
		int i;
		if (manyItems == 0) {
			arr[0] = val;
			manyItems++;
			return;
		}
		
		for(i = manyItems - 1; i >= 0; i--) {
			if(val > arr[i]) {
				arr[i+1] = arr[i];
			}else {
				break;
			}
		}
		
		arr[i+1] = val;
		manyItems++;
	}
	
	public int remove() {
		return arr[--manyItems];
	}
	
	public boolean isFull() {
		return manyItems == MAX;
	}

	public boolean isEmpty() {
		return manyItems == 0;
	}
	
	public int getPeek() {
		return arr[manyItems = 1];
	}
	
	
	
	
	
	
	
	
	
	
	
}*/
