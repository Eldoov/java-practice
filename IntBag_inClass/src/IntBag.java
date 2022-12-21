
public class IntBag {
	public static final int INITIAL_SIZE = 32;
	private int[] bag; // array bag
	private int count; // create count
	
	public IntBag() {
		count = 0;
		bag = new int[INITIAL_SIZE]; // set an initial size
	}
	
	public boolean isFull() {
		if (count == bag.length) {
			return true;
		}
		return false;
	}
	
	public IntBag(int initialSize) {
		bag = new int[initialSize];
		count = 0;
}
	
	public void add(int value) { 
		if (isFull()) {
			int[] newbag = new int[bag.length + INITIAL_SIZE];
			// need to copy bag to new bag
			for(int i=0; i < count; i++) {
				newbag[i] = bag[i];
			}
			bag = newbag;
		}
		bag[count] = value;
		count++;
	}
	
	public int getSize() {
		return count;
	}
	
	public boolean remove(int target) {
		for(int i=0; i < count; i++) {
			if(target == bag[i]) {
				bag[i] = bag[count-1];// copy last element to replace bag[i]
				count -= 1; // keep invariant true, count is one less
				return true;
			}
		}
		return false;
	}
	
	public void addAll(IntBag other) {
		for(int i=0; i < other.count;i++) {
			add(other.bag[i]);
		}
	}
	
	public static IntBag union(IntBag b1, IntBag b2) {
		IntBag result = new IntBag();
		b1.addAll(b2);
		result.addAll(b1);
		return result;
	}
	
	public int getCapacity() {
		return bag.length;
	}
	
	public String toString() {
		String retn = "Bag count: " + count + "\n";
		if(count == 0) {
			retn += "Bag is empty :(\n";
		}
		for(int i=0; i < count; i++) {
			retn += "bag[" + i + "] = " + bag[i] + "\n";
		}
		return retn;
	}
	
	public int countOccur(int target) {
		int tally = 0;
		for(int i=0; i < count;i++) {
			if (bag[i] == target) {
				tally++;
			}
		}
		return tally;
	}
	
	public void addMany(int ... elements) { /// ...thing was smart
		for(int i=0; i < elements.length; i++) {
			add(elements[i]);
		}
	}
	
	
}
