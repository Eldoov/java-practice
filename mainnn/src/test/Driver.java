package test;
//CS342 - Program2 Airport Simulation
//by: Zuowen Tang

import java.util.Random;
import java.util.Scanner;

public class Driver {


 public static void main(String[] args) {
	 
	 System.out.println("First Run:\n");
     start(2,5,1,3,2,100);
     System.out.println("\n\nSecond Run:\n");
     start(5,4,3,2,15,300);
     System.out.println("\n\nThird Run:\n");
     start(1,2,3,4,5,500);
     System.out.println("\n\nForth Run:\n");
     start(3,1,2,2,1,550);
     System.out.println("\n\nFifth Run:\n");
     start(7,7,7,10,2,360);
     System.out.println("\n\nSixth Run:\n");
     start(3,8,2,1,3,900);
     System.out.println("\n\nRequest Run:\n");
     start(3,4,2,1,3,600);

 }
 
 public static void askUser() {
	 // ASK USER TO ENTER THE VARIABLES
	 
     Scanner scan = new Scanner(System.in);
     System.out.println("The amount of time needed for one plane to land: ");
     int setLandingNum = scan.nextInt();
     System.out.println("The amount of time needed for one plane to takeoff: ");
     int setDepartNum = scan.nextInt();
     System.out.println("The average amount of time between arrival of planes to the landing queue: ");
     int aveLanding = scan.nextInt();
     System.out.println("The average amount of time between arrival of planes to the takeoff queue: ");
     int aveDepart = scan.nextInt();
     System.out.println("The maximum amount of time that a plane can stay in the landing queue without running out of fuel and crashing: ");
     int maxWaiting = scan.nextInt();
     System.out.println("The total length of time to be simulated:");
     int DayTime = scan.nextInt();
     
     // STARR SIMULATE
     start(setLandingNum, setDepartNum, aveLanding, aveDepart, maxWaiting, DayTime);
 }

 public static void start(int setLandingNum, int setDepartNum, int aveLanding, int aveDepart, int maxWaiting, int DayTime) {

	 int WaitingTime = 0;
	 int TotalLandingTime = 0, TotalDepartTime = 0, crush = 0, clock = 0;
	 int LandingCount = 0, DepartCount = 0;
	 int EntryTime;
	 
     ArrayQueue LandingQueue = new ArrayQueue(); // create new queue for flight to land
     ArrayQueue DepartQueue = new ArrayQueue(); // create new queue for flight to depart
     
     Random LandingArrival = new Random();  // GENERATE RANDOM NUMS TO DETERMINE WHEN A PLANE ARRIVES TO LAND
     Random DepartArrival = new Random();  // GENERATE RANDOM NUMS TO DETERMINE WHEN A PLANE ARRIVES TO TAKE OFF
     
     // start loop, DayTime is the clock
     while(clock <= DayTime) {
    	 
         // check if there's plane on the run way
         if (WaitingTime != 0) {
             WaitingTime--;
         }

         // check if new flight (landing) arrives
         if (LandingArrival.nextInt(aveLanding) == 0) { 
        	 LandingQueue.add(clock); // add a new flight to landing queue
         }
         
         // check if new flight (depart) arrives
         if (DepartArrival.nextInt(aveDepart) == 0) {
             DepartQueue.add(clock); 
         }
             
         // check if there's flight needs to land
         if(WaitingTime == 0 && !LandingQueue.isEmpty()){
        	 // check if there's plane crushed
             int check;
             for(int i=0; i < LandingQueue.getSize(); i++) {
            	 check = LandingQueue.getNext(i);
            	 if((clock - check) > maxWaiting) {
            		 LandingQueue.removeTarget(i); // remove crushed flight
            		 crush++; // total crushed flights
            	 }
             }
             
             LandingQueue.remove();// move flight to run way and start waiting time
             LandingCount++;
             WaitingTime = setLandingNum+1;
             TotalLandingTime += WaitingTime; // count total time takes to land
         }else if(WaitingTime == 0 && !DepartQueue.isEmpty()){
             DepartQueue.remove(); // remove current flight to run way
             WaitingTime = setDepartNum+1; 
             TotalDepartTime += WaitingTime; // count total time takes to take off
             DepartCount++;
         }
         
         clock++; // count down the clock
     }

     System.out.println("There're total " + DepartCount + " planes took off from the airport.");
     System.out.println("There're total " + LandingCount + " planes landing to the airport.");
     System.out.println("During the waiting time, there're " + crush + " planes crushed.");
     
     if(DepartCount != 0)
    	 System.out.println("The average time a plane spent in the takeoff queue is " + DayTime/DepartCount + " minutes.");
     
     if(LandingCount != 0)
    	 System.out.println("The average time a plane spent in the landing queue is " + DayTime/LandingCount + " minutes.");
     
 	}
     
}


