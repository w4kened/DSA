package w4kened;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        System.out.println(w4kened.BinarySearch_DSA.search(new int[] {2,1,4,5}, 5));
//        demonstrateLists();
//        demonstrateQueues();
//        demonstrateTrees();
//        demonstrateHashmap();
        demonstrateMinheap();

    }

    private static void demonstrateLists() {
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
//        System.out.println(tracks.findNodeRecursively("Z", tracks.head));
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
    }

    private static void demonstrateQueues() {
        Queue_DSA coffeeOrder = new Queue_DSA();
        System.out.println("coffeeOrder Queue_DSA has " + coffeeOrder.size + " orders.");
        coffeeOrder.enqueue("latte");
        coffeeOrder.enqueue("espresso");
        coffeeOrder.enqueue("cappuccino");
    }

    private static void demonstrateHashmap() {
        HashMap_DSA birdCensus = new HashMap_DSA(15);
        birdCensus.assign("mandarin duck", "Central Park Pond");
        birdCensus.assign("monk parakeet", "Brooklyn College");
        birdCensus.assign("horned owl", "Pelham Bay Park");
        System.out.println("> "+birdCensus.retrieve("mandarin duck"));
        System.out.println(birdCensus.retrieve("monk parakeet"));
        System.out.println(birdCensus.retrieve("horned owl"));
    }

    private static void demonstrateTrees() {
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

        long startTime = System.nanoTime(); // ... the code being measured ...
        letters.breadthFirstTraversal();
        long elapsedNanos = System.nanoTime() - startTime;
        System.out.println( elapsedNanos + " nanoseconds" );

        startTime = System.nanoTime();
        letters.depthFirstTraversal(letters.root);

        elapsedNanos = System.nanoTime() - startTime;
        System.out.println( elapsedNanos + " nanoseconds" );


        // Insert values below:
        System.out.println("Creating Binary Search Tree rooted at value 15:");
        BinarySearchTree_DSA tree = new BinarySearchTree_DSA(15);

        for (int i = 0; i < 100; i++) {
            tree.insert((int) (-2 + Math.random() * 5));
        }

        System.out.println("Printing the inorder depth-first traversal:");
        tree.depthFirstTraversal();
    }

    private static void demonstrateMinheap() {
        MinHeap_DSA minHeap = new MinHeap_DSA();
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int int_random = r.nextInt(40);
            minHeap.add(int_random);
        }
        System.out.println("--------------");
        System.out.println("BUBBLED UP: " + minHeap.heap);

        // Remove minimum value multiple times
        for (int i = 0; i < 6; i++) {
            System.out.println("--------------");
            minHeap.popMin();
            System.out.println("HEAPIFIED: " + minHeap.heap);
        }
    }
}


