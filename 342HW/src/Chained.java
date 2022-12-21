public class Chained {
    String value;
    Chained next;

    public Chained(String value){
        this.value = value;
        next = null;
    }

    public Chained getNext() {
        return next;
    }

    public String getValue(){
        return value;
    }

}
