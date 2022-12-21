package edu.bu.met.cs342;

public class GenericData<E> {
    private E data;

    public GenericData(E data){
        this.data = data;
    }
    public GenericData(){

    }
    public E getData(){
        return data;
    }
    public void setData(E data){
        this.data = data;
    }
    public String toString(){
        return "" + data;
    }

    /**
     * Compares two GenericData.data elements
     * @param obj a GenericData object
     * @return true if obj.getData() is equal to this.data
     */
    public boolean equals(Object obj) {
        return ((GenericData<E>) obj).getData().equals(data);
    }
}
