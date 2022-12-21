package edu.bu.met.cs342;

public class Customer {
    private int arrivalTime;
    private int processingTime;
    private int helpNeededMin;

    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public int getProcessingTime() {
        return processingTime;
    }
    public void setProcessingTime(int processingTime) {
        this.processingTime = processingTime;
        helpNeededMin = processingTime;
    }
    public void helpTimeMinutes(int helpMinutes){
        helpNeededMin -= helpMinutes;
    }

    public boolean isSatisfied(){
        if (helpNeededMin < 1) {
            return true;
        }
        return false;
    }
}
