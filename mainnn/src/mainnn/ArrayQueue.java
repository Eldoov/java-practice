package mainnn;
public class ArrayQueue {

    private Plane[] queue;
    private static int count = 0; 
    private int head;
    private int tail;
    private int size = 0;

    public ArrayQueue(int capacity) {
        size = capacity;
        head = 0;
        tail = 0;
        count = 0;
        queue = new Plane[size];
    }

    public void add(Plane plane) {
        ensureCapacity();
        queue[tail++] = plane;
        count++;
    }

    public Plane remove() {
        if (count == 0) {
            return null;
        }

        Plane currentPlane;
        currentPlane = queue[head];

        head++;
        count--;
        return currentPlane;
    }

    public int getSize(){
        return count;
    }

    public boolean isEmpty() {
        return (count == 0);
    }

    public void ensureCapacity() {
        if (count >= size | tail >= size) {
            size = (size * 2) + 1;  // size for new array
            Plane newQueue[] = new Plane[size];  // creates an new array

            int j=0;
            for (int i=head; i<tail; i++) {  // loop through old array, copy stuff to new array
                newQueue[j++] = queue[i];
            }
            head = 0;
            tail = count;

            queue = newQueue;
        }

    }
}
