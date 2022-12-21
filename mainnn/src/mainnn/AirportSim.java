package mainnn;
import java.util.Random;
public class AirportSim {

    public static int id, crush, DepartArrival, LandingArrival, LandingCount, DepartCount = 0;
    public static int WaitingTime;
    public static int MAX = 10000;

    public static int setID(){
        id++;
        return id;
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
            }

            if(LandingArrival == 0){
                LandingQueue.add(new Plane(setID(),DayTime,2)); // add a new flight to landing queue
                LandingArrival = r.nextInt(setLandingNum); // set up a new cycle
                LandingCount++;
            }

            if (DepartArrival != 0) {
                DepartArrival--;
            }
            if (DepartArrival == 0) {
                DepartQueue.add(new Plane(setID(), DayTime, 1)); // add a new flight to depart queue
                DepartArrival = r.nextInt(setDepartNum); // set up a anew cycle
                DepartCount++;
            }
                
            /*         
            if(WaitingTime == 0 && !LandingQueue.isEmpty()){
                LandingQueue.remove();
                WaitingTime = setLandingNum;
            }

            if(WaitingTime == 0 && LandingQueue.isEmpty()){
                DepartQueue.remove();
                WaitingTime = setDepartNum;
            }

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
