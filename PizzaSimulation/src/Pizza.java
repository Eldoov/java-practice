public class Pizza {

    private int cookTime, ID;

    public Pizza(int cookTime, int ID){
        this.cookTime = cookTime;
        this.ID = ID;
    }

    public int getCookTime(){
        return cookTime;
    }

    public int getID(){
        return ID;
    }

    public int setCookTime(){
        cookTime--;
        return cookTime;
    }


}
