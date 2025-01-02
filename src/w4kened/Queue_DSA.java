package w4kened;

public class Queue_DSA {
    private LinkedList_DSA Queue_DSA;
    public int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;

    public Queue_DSA() {
        this(DEFAULT_MAX_SIZE);
        this.size    = 0;

    }

    public Queue_DSA(int maxSize) {
        this.Queue_DSA   = new LinkedList_DSA();
        this.size    = 0;
        this.maxSize = maxSize;
    }

    public void enqueue(String data) {
        if (this.hasSpace()) {
            Node newNode = new Node(data);
            this.Queue_DSA.addToTail(newNode);
            this.size += 1;

            System.out.println("Added "+data+"! Queue_DSA size is now "+size);
        }
        else {
            throw new Error("Queue_DSA is full!");
        }
    }

//    public void enqueue(Vertex data) {
//        this.Queue_DSA.addToTail(data);
//    }

    // Define deQueue_DSA() below
    public String deQueue_DSA() {
        if (!isEmpty()) {
            String data = this.Queue_DSA.removeHead();
            this.size -= 1;
            System.out.println("Removed "+data+"! Queue_DSA size is now "+this.size);

            return data;
        }
        else {
            throw new Error("Queue_DSA is empty!");
        }
    }

    public String peek() {
        if (!isEmpty()) {
            return this.Queue_DSA.head.data;
        }
        return null;
    }

    public boolean hasSpace() {
        if (this.size < this.maxSize) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (this.size <= 0) {
            return true;
        }
        return false;
    }



}
