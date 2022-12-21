import java.lang.annotation.Target;

public class ArrayParty {

    private Party[] PartyQueue;
    private int head, tail, count;
    private int capacity;

    public ArrayParty(int cap){
        head = 0;
        tail = 0;
        this.count = 0;
        this.capacity = cap;
        PartyQueue = new Party[capacity];
    }

    public boolean isFull(){
        if(count == PartyQueue.length){
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return(count == 0);
    }

    public void add(Party party){
        if(isFull()){
            return;
        }
        PartyQueue[tail++] = party;
        count++;
    }

    public void removeTarget(int target){
        if(isEmpty()){
            return;
        }

        for(int i = target; i < tail - 1; i++){
            PartyQueue[i] = PartyQueue[i+1];
        }

        if(tail < capacity){
            Party temp = new Party(0,0,0);
            PartyQueue[tail] = temp;
            tail--;
        }

        count--;
        return;
    }


    public int isMatch(int val){
        for(int i = 0; i < count; i++){
            if(PartyQueue[i].getPartyID() == val){
                return i;
            }
        }
        return 9999; // random impossible number
    }

    public void deliverPizza(int val){
        if(PartyQueue[val].getPizzaNum() > 0){
            PartyQueue[val].setPizzaNum();
        }
        return;
    }

    public int getSize(){
        return count;
    }

    public int getLength(){
        return PartyQueue.length;
    }

    public Party getTarget(int target) {
        Party rtn;
        rtn = PartyQueue[target];
        return rtn;
    }

    public String toString() {
        String rtn = "ArrayParty count: " + count + "\n";
        if(count == 0) {
            rtn += "Queue is empty :(\n";
        }
        for(int i=0; i < count; i++) {
            rtn += "ArrayParty[" + i + "]\n";
        }
        return rtn;
    }

    public Party getHead(){
        return PartyQueue[head];
    }

}
