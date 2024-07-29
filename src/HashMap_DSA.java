import java.math.BigInteger;

public class HashMap_DSA {
    public LinkedList_DSA[] hashmap;

    public HashMap_DSA(int size) {
        this.hashmap = new LinkedList_DSA[size];
        for (int i = 0; i < size; i++) {
            this.hashmap[i] = new LinkedList_DSA();
        }
    }

    public int hash(String key) {
        int hashCode = 0;
        for (int i = 0; i < key.length(); i++) {
            hashCode += Character.codePointAt(key, i);
        }
        return hashCode % this.hashmap.length;
    }

    public void assign(String key, String value) {
        int arrayIndex = this.hash(key);
        LinkedList_DSA list = this.hashmap[arrayIndex];

        if (list.head == null) {
            System.out.println("new list");
            list.addToHead(new Node(key, value));
            return;
        }
        Node current = list.head;
        while (current != null) {
            if (current.key.equals(key)) {
                System.out.println("key value "+key+" "+value);
                current.setKeyValue(key, value);
                return;
            }
            if (current.getNextNode() == null) {
                current.setNextNode(new Node(key, value));
                break;
            }
            current = current.getNextNode();
        }

    }

    public String retrieve(String key) {
        int arrayIndex = this.hash(key);
        Node current = this.hashmap[arrayIndex].head;

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.getNextNode();
        }

        return null;
    }
}
