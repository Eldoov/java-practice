// CS342 - Program2 Airport Simulation
// by: Zuowen Tang

import java.util.Scanner;
import java.util.Random;

public class AirportSim {
	
	public int LandingCount, DepartCount = 0;
	public int LandingArrival, DepartArrival = 0;
	public int WaitingTime, TotalLandingTime, TotalDepartTime, crush = 0;
	
	public int n1, n2 ,n3, n4, n5, n6;
	
	public int MAX = 100;
	
	public void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("The amount of time needed for one plane to land: ");
		n1 = scan.nextInt();
		System.out.println("The amount of time needed for one plane to takeoff: ");
		n2 = scan.nextInt();
		System.out.println("The average amount of time between arrival of planes to the landing queue: ");
		n3 = scan.nextInt();
		System.out.println("The average amount of time between arrival of planes to the takeoff queue: ");
		n4 = scan.nextInt();
		System.out.println("The maximum amount of time that a plane can stay in the landing queue without running out of fuel and crashing: ");
		n5 = scan.nextInt();
		System.out.println("The total length of time to be simulated:");
		n6 = scan.nextInt();
		
		AirportSim(n1, n2, n3, n4, n5, n6);
		
		System.out.println("Num of Landing: " + LandingCount + ". Num of Depart: " + DepartCount + ". Crushed Planes: " + crush);
		System.out.println("Average landing time: " + TotalLandingTime/LandingCount);
		System.out.println("Average depart time " + TotalDepartTime/DepartCount);
		
	}
	
	public void AirportSim(int setLandingNum, int setDepartNum, int aveLanding, int aveDepart, int maxWaiting, int DayTime) {
		
		Random r = new Random();
		
		ArrayQueue Qlanding = new ArrayQueue(MAX);
		ArrayQueue Qdepart = new ArrayQueue(MAX);
		
		while(DayTime > 0) {
			if (WaitingTime != 0) {
				WaitingTime--;
			}
			
			if (LandingArrival != 0) { // check if new flight arrives
				LandingArrival--;
			}else {
				Qlanding.add(0); // add a new flight to landing queue
				LandingArrival = r.nextInt(setLandingNum); // set up a new cycle
				LandingCount++;
			}
			
			if (DepartArrival != 0) {
				DepartArrival--;
			}else {
				Qdepart.add(0); // add a new flight to depart queue
				DepartArrival = r.nextInt(setDepartNum); // set up a anew cycle
				DepartCount++;
			}
			
			// check if any flight crushes
			
			for(int i=0; i < Qlanding.size(); i++) {
				
				
			}
			
			
		}
		
		
		
	}


}
