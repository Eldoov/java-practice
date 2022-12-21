package edu.bu.met.cs342;

public interface MyBag {
    void add(Integer data);

    void addAll(LinkedBag addend);

    void addMany(Integer... elements);

    boolean remove(Integer target);

    void trimToSize();

    boolean isFull();

    int size();

    void ensureCapacity(int minimumCapacity);

    int getCapacity();

    int countOccurrences(Integer value);

    public MyBag clone();
}
