package edu.bu.met.cs342;
import java.util.Random;

public class BankSim {
    private static final int DAY_LENGTH = 480;
    private int minute;
    private int numTellers;
    private int custArrivalFreq;
    private int custProcessingTime;
    private LinkedQueue<Customer> queue;
    private Teller []teller;
    private int totalCustomersProcessed;

    public void setupSim() {
        numTellers = 4;
        custArrivalFreq = 3;
        custProcessingTime = 12;
        totalCustomersProcessed = 0;
        queue = new LinkedQueue<Customer>();
        teller = new Teller[numTellers];
        for (int i = 0; i < teller.length; i++) {
            teller[i] = new Teller();
        }
    }

    public void doSim(int seed) {

        int nextCustArrival;
        Random gen = new Random(seed);
        // Generate an arrival time between 1 and twice custArrivalFreq
        nextCustArrival = gen.nextInt(custArrivalFreq*2)+1;

        for (minute = 0; minute < DAY_LENGTH; minute++) {

            // Handle customer arrival
            if (minute == nextCustArrival) {
                nextCustArrival = minute + gen.nextInt(custArrivalFreq*2)+1;

                // Generate a new customer
                Customer cust = new Customer();
                cust.setArrivalTime(minute);
                cust.setProcessingTime(gen.nextInt(custProcessingTime*2)+1);

                // Enqueue the customer
                queue.add(cust);
                System.out.println("New customer arrived at " + minute + " line length " + queue.count) ;
                System.out.println("\tWill take " + cust.getProcessingTime() +
                        " to process.");
            }

            // Deal with the teller completion
            for (int i = 0; i < teller.length; i++) {
                if (teller[i].isBusy()) {
                    // See if the teller is done.
                    if (teller[i].getTimeTellerGotCust() +
                            teller[i].getCust().getProcessingTime() <=
                            minute) {
                        teller[i].setBusy(false);
                        totalCustomersProcessed++;
                    }
                }
            }

            // Handle the customer handoff to a teller
            if (queue.size() > 0) {
                for (int i = 0; i < teller.length; i++) {
                    if (queue.size() > 0) {
                        if (!teller[i].isBusy()) {
                            // Assign this customer
                            Customer cust = queue.remove();
                            teller[i].setCust(cust);
                            teller[i].setBusy(true);
                            teller[i].setTimeTellerGotCust(minute);
                        }
                    }
                }
            }
        }

        // Print out statistics.
        System.out.println("Queue depth         = " + queue.size());
        System.out.println("Customers processed = " + totalCustomersProcessed);
        if (queue.size() > 0) {
            System.out.println("Longest wait        = " + (minute - queue.queueHead().getArrivalTime()));

        }
    }
}
