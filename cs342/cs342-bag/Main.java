package edu.bu.met.cs342;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.doIt();
    }
    private void doIt() {
        LinkedList list = new LinkedList();

        list.addToHead(10);
        list.addToHead(20);
        list.addToHead(30);

        System.out.println(list.search(50));
        System.out.println(list);

        list.addAfter(20, 25);

        System.out.println(list);
        System.out.println(list.deleteAfter(25));

        System.out.println(list);

        list.addBefore(20, 100);
        System.out.println(list);

        list.addBefore(30, 200);
        System.out.println(list);

        System.out.println(list.deleteBefore(20));
        System.out.println(list);

        System.out.println(list.deleteBefore(30));
        System.out.println(list);

        System.out.println(list.deleteBefore(30));
        System.out.println(list);

        while(!list.isEmpty()) {
            System.out.println(list.removeFromHead());
        }
    }

}
