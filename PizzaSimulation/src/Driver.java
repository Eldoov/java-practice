import java.util.Random;
public class Driver {

    public static void main(String[] args){

        System.out.println("Sim 1 - 6 ovens & unlimited tables: \n");
        pizzaSim(480, 6, 10, 10000, false);
        System.out.println("\n\nSim 2 - 10 tables & needed ovens: \n");
        pizzaSim(480, 6, 10, 10, true);



    }


    public static void test(){
        int tfp = 0, twt = 0, max = 0;
        ArrayPizza pizza = new ArrayPizza(1000);
        ArrayParty table = new ArrayParty(1000);

        table.add(new Party(1,1,1));
        table.add(new Party(2,2,2));
        table.add(new Party(3,3,3));
        table.add(new Party(1,1,4));

        pizza.add(new Pizza(0,1));
        pizza.add(new Pizza(0,2));
        pizza.add(new Pizza(0,2));
        pizza.add(new Pizza(0,3));
        pizza.add(new Pizza(0,3));
        pizza.add(new Pizza(0,3));
        pizza.add(new Pizza(0,4));

        if(!pizza.isEmpty()){
            Pizza pizza0;
            Party party0;
            int temp;
            for(int i = 0; i < pizza.getSize(); i++){ // go through entire delivery list
                pizza0 = pizza.getTarget(i);
                temp = table.isMatch(pizza0.getID());
                System.out.println(temp);
                if(temp != 9999){ // search for pizza ID to see if it fits any table
                    table.deliverPizza(temp);
                    party0 = table.getTarget(temp);

                    if(party0.isFirstPizza()){ // check if this pizza is the first pizza delivered to the table
                        tfp++;
                        twt += (10 - party0.getPartyID());
                        if(max < (10 - party0.getPartyID())){
                            max = (10 - party0.getPartyID());
                        }
                    }

                }
            }
        }

        System.out.println(twt);
        System.out.println(tfp);
        System.out.println(max);



    }


    public static void pizzaSim(int dayTime, int ovenNum, int cookTime, int tableNum, boolean manyOven){
        ArrayPizza oven = new ArrayPizza(ovenNum);
        ArrayPizza order = new ArrayPizza(10000);
        ArrayPizza delivery = new ArrayPizza(10000);
        ArrayParty table = new ArrayParty(tableNum);
        ArrayParty lobby = new ArrayParty(1000);

        Random random = new Random();
        int minute = 0, removePizza = 0;
        int peopleNum, pizzaNum;
        int partyTotal = 0, peopleTotal = 0, pizzaTotal = 0;
        int totalFirstPizza = 0, totalWaitingTime = 0, maxWaitingTime = 0, maxTableTime = 0, maxLobbyTime = 0;
        int aveWaitFrtPizza = 0;

        while(minute <= dayTime){

            // WHEN PARTY ARRIVES
            if(random.nextInt(4) == 0){
                peopleNum = random.nextInt(6)+1; // set numbers of people
                pizzaNum = (peopleNum/2)+1; // set numbers of pizzas

                lobby.add(new Party(peopleNum, pizzaNum, minute));
                if(table.isFull() && maxLobbyTime < lobby.getSize()){
                    maxLobbyTime = lobby.getSize();
                }

                while(!lobby.isEmpty() && !table.isFull()){
                    Party party0;
                    party0 = lobby.getHead();
                    table.add(new Party(party0.getPeopleNum(), party0.getPizzaNum(), minute)); // add party to "table" zone
                    for(int i = 0; i < pizzaNum; i++){ // loop if multiple pizzas is ordered
                        order.add(new Pizza(cookTime, minute)); // use entry time as an ID for each pizza
                    }
                    lobby.removeTarget(0);
                    partyTotal++; // count total numbers of parties
                    peopleTotal += peopleNum; // count total numbers of people
                    pizzaTotal += pizzaNum; // count total numbers of pizza
                }

            }

            // CHECK ORDERS AND SEND PIZZA TO OVEN IF THERE ARE SPACE
            while(!oven.isFull() && !order.isEmpty()){
                oven.add(new Pizza(order.getCookTime(), order.getID()));
                order.remove();

                if(manyOven){ // add more ovens if needed
                    oven.manyOven();
                }
            }
            // START COOKING

            if(!oven.isEmpty()){
                for(int i = 0; i < oven.getSize(); i++){
                    oven.getTarget(i).setCookTime();
                    if(oven.getTarget(i).getCookTime() == 0){
                        delivery.add(oven.getTarget(i));
                        removePizza++;
                    }
                }

                for(int i = 0; i < removePizza; i++){
                    oven.remove();
                }
            }

            // DELIVER PIZZA TO PARTY
            if(!delivery.isEmpty()){
                Pizza pizza0;
                Party party0;
                int temp;
                for(int i = 0; i < delivery.getSize(); i++){ // go through entire delivery list
                    pizza0 = delivery.getTarget(i);
                    temp = table.isMatch(pizza0.getID());
                    if(temp != 9999){ // search for pizza ID to see if it fits any table
                        table.deliverPizza(temp);
                        party0 = table.getTarget(temp);

                        if(party0.isFirstPizza()){ // check if this pizza is the first pizza delivered to the table
                            totalFirstPizza++;
                            totalWaitingTime += (minute - party0.getPartyID());
                            if(maxWaitingTime < (minute - party0.getPartyID())){
                                maxWaitingTime = (minute - party0.getPartyID());
                            }
                        }

                    }
                }
            }

            // CHECK IF PARTY IS LEAVING
            if(!table.isEmpty()){
                Party party0;
                for(int i = 0; i < table.getLength(); i++){ // go through the party list
                    party0 = table.getTarget(i);
                    if(party0 != null){
                        if(party0.getPizzaNum() == 0 && party0.finish()){ // see of any party finished eating
                            if(maxTableTime < (minute - party0.getPartyID())){
                                maxTableTime = (minute - party0.getPartyID());
                            }
                            table.removeTarget(i); // if so, remove target party from the queue
                        }else if(party0.getPizzaNum() == 0 && !party0.finish()){
                            party0.eating(); // spend 20 mins on the table
                        }
                    }
                }
            }



            minute++;
        }

        if(totalWaitingTime!= 0){
            aveWaitFrtPizza = totalWaitingTime / totalFirstPizza;
        }

        // OUTPUT
        System.out.println("Total " + pizzaTotal + " pizza have been sold today.");
        System.out.println("The average waiting time for the first pizza is " + aveWaitFrtPizza + " minute(s).");
        System.out.println("The max waiting time for the first pizza is " + maxWaitingTime + " minute(s).");
        System.out.println("Maximum time a party occupies a table is " + maxTableTime + " minute(s).");
        System.out.println("Total " + partyTotal + " part(ies) and total " + peopleTotal + " guest(s) have been served");
        System.out.println("Largest number of parties waiting for a table is " + maxLobbyTime + ".");
        System.out.println("Total " + oven.getLength() + " oven(s) have been used.");

    }

}
