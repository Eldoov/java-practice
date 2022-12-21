public class ArrayPizza {

    private Pizza[] PizzaQueue;
    private int head, tail, count;
    private static int capacity = 0;


    public ArrayPizza(int cap){
        head = 0;
        tail = 0;
        count = 0;
        this.capacity = cap;
        PizzaQueue = new Pizza[capacity];
    }

    public boolean isFull(){
        if(count == PizzaQueue.length){
            return true;
        }
        return false;
    }

    public void manyOven(){

        Pizza[] newPizzaQueue = new Pizza[PizzaQueue.length + 1];
            // copy queue to new queue
        for(int i=0; i < count; i++) {
            newPizzaQueue[i] = PizzaQueue[i];
        }
        PizzaQueue = newPizzaQueue;

    }

    public boolean isEmpty(){
        return(count == 0);
    }

    public int getLength(){
        return PizzaQueue.length;
    }

    public void add(Pizza pizza){
        if(isFull()){
            System.out.printf("\nQueue is full\n");
            return;
        }
        PizzaQueue[tail++] = pizza;
        count++;
    }

    public void remove(){
        if(isEmpty()){
            return;
        }

        for(int i = 0; i < tail - 1; i++){
            PizzaQueue[i] = PizzaQueue[i+1];
        }

        if(tail < capacity){
            tail--;
        }

        count--;
        return;
    }

    public int getCookTime(){
        return PizzaQueue[head].getCookTime();
    }

    public int getID(){
        return PizzaQueue[head].getID();
    }

    public int getSize(){
        return count;
    }

    public Pizza getTarget(int target) {
        Pizza rtn;
        rtn = PizzaQueue[target];
        return rtn;
    }

    public String toString() {
        String rtn = "ArrayPizza count: " + count + "\n";
        if(count == 0) {
            rtn += "Queue is empty :(\n";
        }
        for(int i=0; i < count; i++) {
            rtn += "ArrayPizza[" + i + "]\n";
        }
        return rtn;
    }

}
