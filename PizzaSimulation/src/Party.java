public class Party {
    private int PeopleNum, PizzaNum, PartyID, eatTime, firstPizza;

    public Party(int PeopleNum, int PizzaNum, int PartyID){
        this.PeopleNum = PeopleNum;
        this.PizzaNum = PizzaNum;
        this.PartyID = PartyID;
        eatTime = 20;
        this.firstPizza = 0;
    }

    public boolean isFirstPizza(){
        if(firstPizza == 0){
            firstPizza = 1;
            return true;
        }
        return false;
    }


    public int getPartyID(){
        return PartyID;
    }

    public int getPeopleNum() {
        return PeopleNum;
    }

    public int getPizzaNum() {
        return PizzaNum;
    }

    public int setPizzaNum(){
        PizzaNum--;
        return PizzaNum;
    }

    public void eating(){
        eatTime--;
        return;
    }

    public boolean finish(){
        if(eatTime == 0){
            return true;
        }
        return false;
    }

}
