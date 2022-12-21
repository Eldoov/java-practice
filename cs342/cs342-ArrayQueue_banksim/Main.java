package edu.bu.met.cs342;

public class Main {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        doIt4(2);
        //Integer myVar = 0;
        String myVar = "";

        if (Object.class.isInstance(myVar)){
            System.out.println(myVar.getClass() + " Is an instance of Object");
        } else {
            System.out.println(myVar.getClass() + " Is NOT an instance of Object");
        }
    }

    private static void doIt() {
        ArrayQueue queue = new ArrayQueue();

        System.out.println(queue);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue.remove());
        System.out.println(queue);

        queue.ensureCapacity(30);
        System.out.println(queue);

        queue.trimToSize();
        System.out.println(queue);
    }

    private static void doIt2() {
        LinkedQueue<Integer> queue = new LinkedQueue<Integer>();

        System.out.println(queue);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        System.out.println(queue.remove());
        System.out.println(queue);

//		queue.ensureCapacity(30);
//		System.out.println(queue);
//
//		queue.trimToSize();
//		System.out.println(queue);
    }
    private static void doIt3(int seed){
        BankSim sim = new BankSim();
        sim.setupSim();
        sim.doSim(seed);
    }

    private static void doIt4(int seed) {
        BankSim2 sim = new BankSim2();
        sim.startDay(seed);
        sim.doSim();
    }

}
