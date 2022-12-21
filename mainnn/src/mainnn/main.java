package mainnn;
// CS342 - Program2 Airport Simulation
// by: Zuowen Tang

import java.util.Random;
import java.util.Scanner;

public class main {
    public static int TotalLandingTime, TotalDepartTime, crush = 0;
    public static int id, DepartArrival, LandingArrival, LandingCount, DepartCount = 0;
    public static int WaitingTime = 0;
    public static int MAX = 10000;

    public static int setID(){
        id++;
        return id;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
/*
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
        
*/
        
        
        //AirportSim.start(setLandingNum, setDepartNum, aveLanding, aveDepart, maxWaiting, DayTime);
        start(2, 4, 100, 1, 3, 30);
        System.out.println("LandingCount is " + LandingCount + ". DepartCount is : " + DepartCount);
        System.out.println("TotalLandingTime is " + TotalLandingTime + ". TotalDepartTime is : " + TotalDepartTime);

        //System.out.println("Num of Landing: " + LandingCount + ". Num of Depart: " + DepartCount + ". Crushed Planes: " + crush);
        //System.out.println("Average landing time: " + TotalLandingTime/LandingCount);
        //System.out.println("Average depart time " + TotalDepartTime/DepartCount);

    }
    

    public static void start(int setLandingNum, int setDepartNum, int aveLanding, int aveDepart, int maxWaiting, int DayTime) {

        Random r = new Random();

        ArrayQueue LandingQueue = new ArrayQueue(MAX);
        ArrayQueue DepartQueue = new ArrayQueue(MAX);

        while(DayTime > 0) {
            // check if there's plane on the runway
            if (WaitingTime != 0) {
                WaitingTime--;
            }

            if (LandingArrival != 0) { // check if new flight arrives
                LandingArrival--;
            }/*else {
                LandingQueue.add(new Plane(setID(),DayTime,2)); // add a new flight to landing queue
                LandingArrival = r.nextInt(aveLanding); // set up a new cycle
                LandingCount++;
            }*/

            if (DepartArrival != 0) {
                DepartArrival--;
            }else {
                DepartQueue.add(new Plane(setID(), DayTime, 1)); // add a new flight to depart queue
                DepartArrival = r.nextInt(aveDepart); // set up a anew cycle
                DepartCount++;
            }
                
                     
            if(WaitingTime == 0 && !LandingQueue.isEmpty()){
                LandingQueue.remove();
                WaitingTime = setLandingNum+1;
                TotalLandingTime = TotalLandingTime + 4;
            }

            if(WaitingTime == 0 && LandingQueue.isEmpty()){
                DepartQueue.remove();
                WaitingTime = setDepartNum+1;
                TotalDepartTime += 3;
            }
            
            //System.out.println(LandingQueue.getSize());

/*
            // check if any flight crushes
            Plane crushPlane;
            for(int i=0; i < LandingQueue.getSize(); i++) {
                crushPlane = LandingQueue.remove();
                if(crushPlane != null && crushPlane.isCrush(DayTime,maxWaiting)){
                    crush++;
                }

            }*/

            DayTime--;
        }
        

    }

}
