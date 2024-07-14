import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*Lists*/
        LinkedList_DSA list = new LinkedList_DSA();
        list.addToTail(new Node("2"));
        list.addToHead(new Node("1"));
        list.addToTail(new Node("3"));
        list.addToTail(new Node("4"));
        list.removeHead();
        list.removeHead();
        list.printList();

        LinkedList_DSA tracks = new LinkedList_DSA();
        tracks.printList();
        tracks.addToHead(new Node("M"));
        tracks.addToHead(new Node("Z"));
        tracks.addToHead(new Node("A"));
        tracks.printList();
        tracks.removeNodeByData("Z");
        tracks.removeNodeByData("M");
//        tracks.removeNodeByData("A");

        DoublyLinkedList_DSA d_list = new DoublyLinkedList_DSA();
        d_list.addToHead(new Node("2"));
        d_list.addToHead(new Node("1"));
        d_list.addToTail(new Node("3"));
        d_list.addToTail(new Node("4"));
//        d_list.addToTail(new Node("5"));
//        d_list.printList();
//        d_list.findMiddle(d_list);
//        tracks.printList();

        System.out.println(BinarySearch_DSA.search(new int[] {2,1,4,5}, 5));

        Queue_DSA coffeeOrder = new Queue_DSA();
        System.out.println("coffeeOrder Queue_DSA has " + coffeeOrder.size + " orders.");
        coffeeOrder.enqueue("latte");
        coffeeOrder.enqueue("espresso");
        coffeeOrder.enqueue("cappuccino");
//        Character.code
//        new Object().hashCode()

        HashMap_DSA aboutMe = new HashMap_DSA(3);
        aboutMe.assign("myFavoriteColor", "brown");
        System.out.println(aboutMe.retrieve("myFavoriteColor"));

    }
}
class Node {
    public String data;
    private Node next;
    private Node previous;
    public Node(String data) {
        this.data = data;
        this.next = null;
        this.previous = null;
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

    public String getData() { return this.data; }
}

