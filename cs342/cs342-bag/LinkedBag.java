package edu.bu.met.cs342;

public class LinkedBag implements MyBag {
    LinkedList list;

    public LinkedBag() {
        list = new LinkedList();
    }

    @Override
    public void add(Integer data) {
        list.addToHead(data);
    }

    @Override
    public void addAll(LinkedBag addend) {
        // We will need an iterator for this.  We will cover that in class;
    }

    @Override
    public void addMany(Integer... elements) {
        for (int i = 0; i < elements.length; i++) {
            list.addToHead(elements[i]);
        }

    }

    @Override
    public boolean remove(Integer target) {
        if (list.delete(target) != null) {
            return true;
        }

        return false;
    }

    @Override
    public void trimToSize() {
        // already trimmed to size...
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void ensureCapacity(int minimumCapacity) {
        // Not applicable to linked lists.
    }

    @Override
    public int getCapacity() {
        return Integer.MAX_VALUE;
    }

    @Override
    public int countOccurrences(Integer value) {
        return list.countOccurrences(value);
    }

    @Override
    public MyBag clone() {
        // We need an iterator for this, we will cover that in class.
        return null;
    }

}
