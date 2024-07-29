import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        LinkedList_DSA list = new LinkedList_DSA();
//        list.addToTail(new Node("2"));
//        list.addToHead(new Node("1"));
//        list.addToTail(new Node("3"));
//        list.addToTail(new Node("4"));
//        list.removeHead();
//        list.removeHead();
//        list.printList();
////
//        LinkedList_DSA tracks = new LinkedList_DSA();
//        tracks.printList();
//        tracks.addToHead(new Node("M"));
//        tracks.addToHead(new Node("Z"));
//        tracks.addToHead(new Node("A"));
//        tracks.printList();
//        tracks.removeNodeByData("Z");
//        tracks.removeNodeByData("M");
////        tracks.removeNodeByData("A");
//
        DoublyLinkedList_DSA d_list = new DoublyLinkedList_DSA();
        d_list.addToHead(new Node("2"));
        d_list.addToHead(new Node("1"));
        d_list.addToTail(new Node("3"));
        d_list.addToTail(new Node("4"));

        System.out.println(BinarySearch_DSA.search(new int[] {2,1,4,5}, 5));

//        Queue_DSA coffeeOrder = new Queue_DSA();
//        System.out.println("coffeeOrder Queue_DSA has " + coffeeOrder.size + " orders.");
//        coffeeOrder.enqueue("latte");
//        coffeeOrder.enqueue("espresso");
//        coffeeOrder.enqueue("cappuccino");

        HashMap_DSA birdCensus = new HashMap_DSA(15);
        birdCensus.assign("mandarin duck", "Central Park Pond");
        birdCensus.assign("monk parakeet", "Brooklyn College");
        birdCensus.assign("horned owl", "Pelham Bay Park");
        System.out.println("> "+birdCensus.retrieve("mandarin duck"));
        System.out.println(birdCensus.retrieve("monk parakeet"));
        System.out.println(birdCensus.retrieve("horned owl"));
//        System.out.println(aboutMe.retrieve("myFavoriteColor"));

    }
}
class Node {

    public String data;
    private Node next;
    private Node previous;

    public String key;          // map
    public String value;        //

    public Node(String data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public void setNextNode(Node node) {
        this.next = node;
    }
    public void setPreviousNode(Node node) {
        this.previous = node;
    }
    public Node getNextNode() {
        return this.next;
    }
    public Node getPreviousNode() {
        return this.previous;
    }
    public void setKeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return this.key;
    }
    public String getValue() {
        return this.value;
    }
    public String getData() {
        return this.data;
    }
}

