package edu.bu.met.cs342;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        doIt(); // Integer link list, add to head and tail, and delete items
        //doIt2(); // String linked list
        //doIt3(); // Double linked list using iterator
        //doIt4(); // Search a list of Integers
        //doIt5(); // Search a list of GenericData
    }
    private static void doIt() {
        DLinkedList<Integer> list1 = new DLinkedList<Integer>();

        System.out.println("After construction list1\n" + list1);
        list1.addToHead(25);
        list1.addToHead(35);
        list1.addToHead(45);
        list1.addToHead(55);
        System.out.println("List1\n" + list1);

        DLinkedList<Integer> list2 = new DLinkedList<Integer>();
        System.out.println("After construction list2\n" + list2);
        list2.addToTail(25);
        list2.addToTail(35);
        list2.addToTail(45);
        list2.addToTail(55);
        System.out.println("list2\n" + list2);

        while(!list1.isEmpty()) {
            System.out.println(list1.removeFromHead());
        }

        System.out.println("list2.search(46) returned " + list2.search(46));

        System.out.println("deleted " + list2.delete(55));
        System.out.println(list2);
        System.out.println("deleted " + list2.delete(25));
        System.out.println(list2);
        System.out.println("deleted " + list2.delete(45));
        System.out.println(list2);
        System.out.println("deleted " + list2.delete(35));
        System.out.println(list2);
    }

    private static void doIt2() {
        DLinkedList<String> list = new DLinkedList<String>();

        list.addToTail("Zebra");
        list.addToHead("Aardvark");
        System.out.println(list);
    }

    private static void doIt3() {
        DLinkedList<Double> list = new DLinkedList<Double>();
        list.addToTail(45.23);
        list.addToHead(34.5);
        list.addToTail(55.67);

        System.out.println(list);

        Iterator<Double> iterator =	list.iterator();

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        iterator =	list.iterator();
        // using has the iterator hasNext and next functions
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        // using for each loop
        for (Double x:list) {
            System.out.println(x);
        }
    }

    private static void doIt4() {

        DLinkedList<Integer> list;
        list = new DLinkedList<Integer>();

        Integer x;
        x = 235; // What is happening here
        list.addToTail(x);

        System.out.println(list);

        System.out.println(list.search(235));
    }
    private static void doIt5() {

        DLinkedList<GenericData<Integer>> list;
        list = new DLinkedList<GenericData<Integer>>();

        GenericData<Integer> x;
        x = new GenericData<Integer>();
        x.setData(234);
        list.addToTail(x);

        System.out.println(list);

        System.out.println(list.search(new GenericData<Integer>(235)));
    }


}
