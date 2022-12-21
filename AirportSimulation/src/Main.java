// CS342 - Program2 Airport Simulation
// by: Zuowen Tang

import java.util.Scanner;

public class Main {
    public int LandingCount, DepartCount = 0;
    public int TotalLandingTime, TotalDepartTime, crush = 0;

    public void main(String[] args) {

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

        AirportSim.start(setLandingNum, setDepartNum, aveLanding, aveDepart, maxWaiting, DayTime);

        System.out.println("Num of Landing: " + LandingCount + ". Num of Depart: " + DepartCount + ". Crushed Planes: " + crush);
        System.out.println("Average landing time: " + TotalLandingTime/LandingCount);
        System.out.println("Average depart time " + TotalDepartTime/DepartCount);

    }

}
