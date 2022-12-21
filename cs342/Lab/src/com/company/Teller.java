package com.company;
public class Teller {
	private boolean busy;
	private Customer cust;
	private int timeTellerGotCust;
	public int cost;
	public int tellerProcessTime;
	public String skill;
	public int getCost(){
		return cost;
	}
	public Teller(int skill){
		switch (skill+1) {
			case 1:
				this.skill = "Novice";
				cost=12;
				tellerProcessTime=5;
				break;
			case 2:
				this.skill = "Intermediate";
				cost=15;
				tellerProcessTime=4;
				break;
			case 3:
				this.skill = "Expert";
				cost=20;
				tellerProcessTime=3;
				break;
		}
	}
	public int getTellerProcessingTime(){
		return tellerProcessTime;
	}
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


}
