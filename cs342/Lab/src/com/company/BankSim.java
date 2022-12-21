package com.company;
import java.util.Random;

public class BankSim {
	private static final int DAY_LENGTH = 480;
	private int minute;
	private int numTellers;
	private int custArrivalFreq;
	private int custProcessingTime;
	public double cost;
	private LinkedQueue<Customer> queue;
	public Teller []teller;
	private int totalCustomersProcessed;

	public static int getDayLength() {
		return DAY_LENGTH;
	}

	public BankSim(int numTellers, int custArrivalFreq) {
		setTotalCustomersProcessed(0);
		setCustProcessingTime(0);
		setCustArrivalFreq(custArrivalFreq);
		int setUp=numTellers+1;
		Random gen = new Random();
		// Generate an arrival time between 1 and twice custArrivalFreq
		int numNovice=gen.nextInt(setUp);
		int numIntermediate=gen.nextInt(setUp-numNovice);
		int numExpert=gen.nextInt(numIntermediate+1);
		setQueue(new LinkedQueue<Customer>());
		//sets tellers based on random numNovice
		teller= new Teller[numTellers];
		for (int tellers=0; tellers<numTellers; tellers++){
			if (tellers<=numNovice){
				teller[tellers]=new Teller(0);
			}
			if (tellers<numIntermediate){
				teller[tellers]=new Teller(1);
			}
			if (tellers<=numExpert){
				teller[tellers]=new Teller(2);
			}
		}
	}
	
	public void doSim() {
		Random gen = new Random();
		// Generate an arrival time between 1 and twice custArrivalFreq
		int nextCustArrival = gen.nextInt(getCustArrivalFreq() * 2) + 1;
		
		for (setMinute(0); getMinute() < getDayLength(); setMinute(getMinute() + 1)) {
		
			// Handle customer arrival
			if (getMinute() == nextCustArrival) {
				nextCustArrival = getMinute() + gen.nextInt(getCustArrivalFreq() *2)+1;
				
				// Generate a new customer
				Customer cust = new Customer();
				cust.setArrivalTime(getMinute());
				cust.setProcessingTime(gen.nextInt(getCustProcessingTime() *2)+1);
				
				// Enqueue the customer
				getQueue().add(cust);
				System.out.println("New customer arrived at " + getMinute());
				System.out.println("\tWill take at least" + cust.getProcessingTime() +
						" to process.");
			}
			
			// Deal with the teller completion
			for (int i = 0; i < getTeller().length; i++) {
				if (getTeller()[i].isBusy()) {
					// See if the teller is done.
					if (getTeller()[i].getTimeTellerGotCust() +
							getTeller()[i].getCust().getProcessingTime()+getTeller()[i].getTellerProcessingTime()<=
							getMinute()) {
						getTeller()[i].setBusy(false);
						setTotalCustomersProcessed(getTotalCustomersProcessed() + 1);
					}
				}
			}
			
			// Handle the customer handoff to a teller
			if (getQueue().size() > 0) {
				for (int i = 0; i < getTeller().length; i++) {
					if (getQueue().size() > 0) {
						if (!getTeller()[i].isBusy()) {
							// Assign this customer
							Customer cust = getQueue().remove();
							getTeller()[i].setCust(cust);
							getTeller()[i].setBusy(true);
							getTeller()[i].setTimeTellerGotCust(getMinute());
						}
					}
				}
			}
		}
		//getting data from teller array
		// Print out statistics.
		int totalCost=0;
		for (int i=0; i<teller.length; i++){
			totalCost+=(teller[i].getCost()*(getDayLength()/60));
		}

		System.out.println("Queue depth         = " + getQueue().size());
		System.out.println("Customers processed = " + getTotalCustomersProcessed());
		System.out.println("Cost per customer = " + (totalCost/getTotalCustomersProcessed()));
		if (getQueue().size() > 0) {
			System.out.println("Longest wait        = " + (getMinute() - getQueue().queueHead().getArrivalTime()));

		}
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getNumTellers() {
		return numTellers;
	}

	public void setNumTellers(int numTellers) {
		this.numTellers = numTellers;
	}

	public int getCustArrivalFreq() {
		return custArrivalFreq;
	}

	public void setCustArrivalFreq(int custArrivalFreq) {
		this.custArrivalFreq = custArrivalFreq;
	}

	public int getCustProcessingTime() {
		return custProcessingTime;
	}

	public void setCustProcessingTime(int custProcessingTime) {
		this.custProcessingTime = custProcessingTime;
	}

	public LinkedQueue<Customer> getQueue() {
		return queue;
	}

	public void setQueue(LinkedQueue<Customer> queue) {
		this.queue = queue;
	}

	public Teller[] getTeller() {
		return teller;
	}

	public void setTeller(Teller[] teller) {
		this.teller = teller;
	}

	public int getTotalCustomersProcessed() {
		return totalCustomersProcessed;
	}

	public void setTotalCustomersProcessed(int totalCustomersProcessed) {
		this.totalCustomersProcessed = totalCustomersProcessed;
	}
}
