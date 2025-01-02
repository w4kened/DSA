package w4kened;

public class Stack_DSA {

    public LinkedList_DSA stack;
    public int size;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;
    public int maxSize;

    public Stack_DSA() {
        this(DEFAULT_MAX_SIZE);
    }

    public Stack_DSA(int maxSize) {
        this.stack = new LinkedList_DSA();
        this.size = 0;
        this.maxSize = maxSize;
    }

    public boolean hasSpace() {
        if (this.size < maxSize) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }


    public void push(String data) {
        if (hasSpace()) {
            this.stack.addToHead(new Node(data));
            this.size++;
            System.out.println("Added " + data + "! Stack size is now " + this.size);
        }
        else {
            throw new Error("Stack is full!");
        }
    }

    public String pop() {
        if(!isEmpty()) {
            String data = this.stack.removeHead();
            this.size--;
            System.out.println("Removed " + data + "! Stack size is now " + this.size);
            return data;
        }
        else {
            throw new Error("Stack is empty!");
        }
    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return this.stack.head.data;
    }

}
