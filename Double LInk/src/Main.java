
public class Main {

	public static void main(String[] args) {
		
		LinkedList mylist = new LinkedList();
		System.out.println(mylist);
		mylist.addToHead(2);
		mylist.addToHead(4);
		System.out.println("Removing " + mylist.removeFromHead());
		System.out.println(mylist);
	}

}
