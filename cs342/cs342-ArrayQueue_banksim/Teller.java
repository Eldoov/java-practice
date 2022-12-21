package edu.bu.met.cs342;

public class Teller {
    private boolean busy;
    private Customer cust;
    private int timeTellerGotCust;

    public int getTimeTellerGotCust() {
        return timeTellerGotCust;
    }
    public void setTimeTellerGotCust(int timeTellerGotCust) {
        this.timeTellerGotCust = timeTellerGotCust;
    }
    public boolean isBusy() {
        return busy;
    }
    public void setBusy(boolean busy) {
        this.busy = busy;
    }
    public Customer getCust() {
        return cust;
    }
    public void setCust(Customer cust) {
        this.cust = cust;
    }
    public void workMinutes(int workMin){
        if (cust != null){
            cust.helpTimeMinutes(workMin);

            if (cust.isSatisfied()) {
                busy = false;
            }
        }

    }
}
