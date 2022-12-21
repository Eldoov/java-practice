public class HashArray {
    public HashTable[] table;
    int size;
    int count = 0;

    public HashArray(int size){
        this.size = size;
        table = new HashTable[size];
    }

    public boolean isFull(){
        return count == size;
    }


    public void put(int key, String data){
        if(isFull()){
            HashTable[] newtable = new HashTable[size*2];
            for(int i=0; i < table.length; i++){
                newtable[i] = table[i];
            }
            table = newtable;
        }

        if(contains(key)){
            put(key+1, data);
            return;
        }
        HashTable tmp = new HashTable(key, data);
        for(int i = 0; i< table.length;i++){
            if(table[i] == null || table[i].data == "DELETED"){
                table[i] = tmp;
                break;
            }
        }
        count++;
    }

    public boolean contains(int key){
        for(int i = 0; i<table.length; i++){
            if(table[i] != null && table[i].data != "DELETED"){
                if(table[i].key == key){
                    return true;
                }
            }
        }
        return false;
    }

    public int getLoc(int key){
        for(int i = 0; i< table.length;i++){
            if (table[i] != null && table[i].data != "DELETED") {
                if(table[i].key == key)
                    return i;
            }
        }
        return -1;
    }

    public String get(int key){
        int loc = getLoc(key);
        if(loc == -1){
            return "The data you're looking for does not exit.";
        }
        return table[loc].data;
    }

    public String delete(int key){
        int loc = getLoc(key);
        if(loc == -1){
            return "This location is empty.";
        }
        table[loc].data = "DELETED";
        return "Your data had been deleted.";
    }

    public void printHash(){
        System.out.println("   Hash Table     ");
        System.out.println("Hash Key     " + "Data      \n");
        for(int i = 0; i < table.length; i++){
            if(table[i] != null){
                System.out.println("   " + table[i].key + "        " + table[i].data);
            }
        }
        System.out.println("");
    }

}
