
public class Driver {

	public static void main(String[] args) {
		//doIt1();
		doIt4();
	}
	
	public static void doIt1() {
		System.out.println(IntBag.INITIAL_SIZE + "\n");
		IntBag mybag = new IntBag();
		System.out.println(mybag);
		mybag.add(9);
		mybag.add(2);
		mybag.add(3);
		mybag.add(94);
		System.out.println(mybag);
	}
	
	public static void doIt2() {
		IntBag b1 = new IntBag();
		System.out.println(b1.getCapacity());
		for(int i = 0; i < IntBag.INITIAL_SIZE; i++) {
			b1.add(i);
		}
		b1.add(3);
		System.out.println(b1.getCapacity());
	}
	
	public static void doIt3() {
		IntBag b1 = new IntBag();
		b1.add(9);
		b1.add(2);
		b1.add(1);
		b1.add(3);
		System.out.println(b1);
		b1.remove(2);
		System.out.println(b1);
	}
	
	public static void doIt4() {		
		IntBag b1 = new IntBag();
		IntBag b2 = new IntBag();
		b1.add(9);
		b1.add(2);
		b1.add(2);
		b2.add(1);
		b2.add(3);
		System.out.println(b1);
		System.out.println(b2);
		//b1.addAll(b2);
		System.out.println(b1.getSize());
		System.out.println(b2.getSize());
	}
	
	public static void doIt5() {		
		IntBag b1 = new IntBag();
		IntBag b2 = new IntBag();
		b1.add(9);
		b1.add(2);
		b2.add(1);
		b2.add(3);
		System.out.println(b1);
		System.out.println(b2);
		IntBag b3 = IntBag.union(b1, b2);
		System.out.println(b3);
	}
	
	public static void doIt6() {		
		IntBag b1 = new IntBag();
		b1.add(9);
		b1.add(2);
		b1.add(9);
		b1.add(1);
		b1.add(9);
		b1.add(5);
		System.out.println(b1.countOccur(0));
	}
	
	public static void doIt7() {
		IntBag b1 = new IntBag();
		b1.addMany(1,2,3,4,5,6,7);
		System.out.println(b1);
	}

}
