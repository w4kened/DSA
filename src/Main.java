import java.util.ArrayList;
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
////        tracks.printList();
////        tracks.removeNodeByData("Z");
////        tracks.removeNodeByData("M");
//////        tracks.removeNodeByData("A");
////
//        DoublyLinkedList_DSA d_list = new DoublyLinkedList_DSA();
//        d_list.addToHead(new Node("2"));
//        d_list.addToHead(new Node("1"));
//        d_list.addToTail(new Node("3"));
//        d_list.addToTail(new Node("4"));
//
//        System.out.println(BinarySearch_DSA.search(new int[] {2,1,4,5}, 5));
//
////        Queue_DSA coffeeOrder = new Queue_DSA();
////        System.out.println("coffeeOrder Queue_DSA has " + coffeeOrder.size + " orders.");
////        coffeeOrder.enqueue("latte");
////        coffeeOrder.enqueue("espresso");
////        coffeeOrder.enqueue("cappuccino");
//
//        HashMap_DSA birdCensus = new HashMap_DSA(15);
//        birdCensus.assign("mandarin duck", "Central Park Pond");
//        birdCensus.assign("monk parakeet", "Brooklyn College");
//        birdCensus.assign("horned owl", "Pelham Bay Park");
//        System.out.println("> "+birdCensus.retrieve("mandarin duck"));
//        System.out.println(birdCensus.retrieve("monk parakeet"));
//        System.out.println(birdCensus.retrieve("horned owl"));
//        System.out.println(tracks.findNodeRecursively("Z", tracks.head));
//        System.out.println(aboutMe.retrieve("myFavoriteColor"));


        TreeNode treeRoot = new TreeNode("S");
        TreeNode child1 = new TreeNode("N");
        TreeNode child2 = new TreeNode("O");
        TreeNode grandchild1 = new TreeNode("W");
        TreeNode grandchild2 = new TreeNode("Y");

        // addChild operations below
        treeRoot.addChild(child1);
        treeRoot.addChild(child2);
        child1.addChild(grandchild1);
        child2.addChild(grandchild2);

        // Create tree
        Tree_DSA letters = new Tree_DSA(treeRoot);
        letters.print();
        treeRoot.removeChild("N");
        letters.print();

    }
}


