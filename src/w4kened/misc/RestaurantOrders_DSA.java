package w4kened.misc;

import w4kened.Queue_DSA;

public class RestaurantOrders_DSA {

    public Queue_DSA headChef;
    public Queue_DSA sousChef;
    public Queue_DSA waitingList;


    public RestaurantOrders_DSA() {
        // Instantiate Queue_DSAs here
        this.headChef = new Queue_DSA(3);
        this.sousChef = new Queue_DSA(3);
        this.waitingList = new Queue_DSA();
    }

    public void assign(String[] orders) {
        for (String order : orders) {
            try {
                this.headChef.enqueue(order);
                System.out.println("Order for " + order + " taken by Head Chef.");
                // Assign orders to Head Chef

            } catch (Error e) {
                if (this.sousChef.hasSpace()) {
                    System.out.println("Head Chef is busy! Assign " + order + " order to Sous Chef.");
                    this.sousChef.enqueue(order);
                    // Assign orders to Sous Chef
                }
                else {
                    this.waitingList.enqueue(order);
                    System.out.println("Both chefs are busy! Add " + order + " order to the waiting list.");
                }
            }

        }
        System.out.println("-----------------");
        System.out.println("You've got only " + this.waitingList.size + " orders on the waiting list. Keep up the hard work chefs!");
    }
    public static void main(String[]args) {}
}