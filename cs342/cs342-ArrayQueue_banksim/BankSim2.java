package edu.bu.met.cs342;

import java.util.Random;

public class BankSim2 {
    private static final int DAY_LENGTH = 480;
    private int minute;
    private int numTellers;
    private int custArrivalFreq;
    private int custProcessingTime;
    private int maxCustomerWaitTime;
    private LinkedQueue<Customer> queue;
    private int nextCustArrival;
    private Teller[] teller;
    private int totalCustomersProcessed;
    private Random gen;

    public void startDay(int seed){
        numTellers = 4;
        custArrivalFreq = 3;
        custProcessingTime = 12;
        totalCustomersProcessed = 0;
        maxCustomerWaitTime = 0;
        queue = new LinkedQueue<Customer>();
        teller = new Teller[numTellers];
        for (int i = 0; i < teller.length; i++) {
            teller[i] = new Teller();
        }
        gen = new Random(seed);
        // Generate an arrival time between 1 and twice custArrivalFreq
        nextCustArrival = gen.nextInt(custArrivalFreq * 2) + 1;
    }

    public boolean anyTellerWithCustomer(){
        boolean rtn = false;
        for (Teller t : teller){
            if (t.isBusy()){
                rtn = true;
            }
        }
        return rtn;
    }
    public void runLobby() {
        // Handle customer arrival
        if (minute == nextCustArrival) {
            nextCustArrival = minute + gen.nextInt(custArrivalFreq * 2) + 1;

            // Generate a new customer
            Customer cust = new Customer();
            cust.setArrivalTime(minute);
            cust.setProcessingTime(gen.nextInt(custProcessingTime * 2) + 1);

            // Enqueue the customer
            queue.add(cust);
            System.out.println("New customer arrived at " + minute + " line length " + queue.count);
            System.out.println("\tWill take " + cust.getProcessingTime() +
                    " to process.");
            totalCustomersProcessed++;
        }
    }
    public void helpCustomers(){
        // Drive the tellers
        for (int i = 0; i < teller.length; i++) {
            if (queue.size() > 0) {
                if (!teller[i].isBusy()) {
                    // Assign this customer
                    Customer cust = queue.remove();
                    int custWaitMin = minute - cust.getArrivalTime();
                    if (maxCustomerWaitTime < custWaitMin){
                        maxCustomerWaitTime = custWaitMin;
                    }
                    teller[i].setCust(cust);
                    teller[i].setBusy(true);
                    teller[i].setTimeTellerGotCust(minute);
                }
            }
            teller[i].workMinutes(1);
        }

        minute++;
    }

    public void doSim() {
        do {
            runLobby();
            helpCustomers();
        }while (minute < DAY_LENGTH);
        System.out.println("Doors closing and " + queue.count + " customers in line");
        do {
            helpCustomers();
        } while(anyTellerWithCustomer());
        // Print out statistics.
        System.out.println("Last customer left " + (minute - DAY_LENGTH) + " minutes after closing");
        System.out.println("Customers processed = " + totalCustomersProcessed);
        System.out.println("Longest wait        = " + maxCustomerWaitTime);

    }
}