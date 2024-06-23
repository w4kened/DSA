public class Queue_DSA {
    private LinkedList_DSA queue;
    public int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;

    public Queue_DSA() {
        this(DEFAULT_MAX_SIZE);
    }

    public void enqueue(String data) {
        Node newNode = new Node(data);
        this.queue.addToTail(newNode);
        this.size += 1;


        System.out.println("Added "+data+"1 Queue size is now "+size);
    }

    // Define dequeue() below
    public String dequeue() {
        String data = this.queue.removeHead();
        this.size -= 1;
        System.out.println("Removed "+data+"! Queue size is now "+this.size);

        return data;
    }

    public String peek() {
        return this.queue.head.data;
    }

    public Queue_DSA(int maxSize) {
        this.queue   = new LinkedList_DSA();
        this.size    = 0;
        this.maxSize = maxSize;
    }
}
