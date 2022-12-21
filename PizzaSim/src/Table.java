
public class Table {
	
	public int tableNum;
	private int count = 0;
	
	public int[] Table = new int[tableNum];
	
	public void setTableNum(int num) {
		tableNum = num;
	}
	
	public boolean isFull() {
		if(count == Table.length) {
			return true;
		}
		return false;
	}
	
	public void add(int party) {
		if (isFull()) {
				System.out.println("Tables are full. Please wait in the lobby.");
			}
		Table[count] = party;
		count++;
	}
	
	public boolean remove(int target) {
		for(int i = 0; i < Table.length; i++) {
			if (target == Table[i]) {
				Table[i] = Table[i-1];
				count--;
				return true;
			}
		}
		return false;
	}

}
