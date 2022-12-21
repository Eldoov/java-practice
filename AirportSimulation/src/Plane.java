public class Plane{
    public int EntryTime;
    public int Priority;
    public int planeID;

    public Plane(int planeID, int EntryTime, int Priority) {
        this.planeID = planeID;
        this.EntryTime = EntryTime;
        this.Priority = Priority;
    }

    public boolean isCrush(int DayTime, int maxWaiting){
        return (DayTime - EntryTime) < maxWaiting;
    }
}
