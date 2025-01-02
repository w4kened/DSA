package w4kened;

import java.util.Objects;

public class DoublyLinkedList_DSA {
    public String data;
    public Node head;
    public Node tail;

    public DoublyLinkedList_DSA() {
        this.head = null;
        this.tail = null;
    }



    public String printList() {
        Node currentNode = this.head;
        String output = "<head> ";
        while (currentNode != null) {
            output += currentNode.data + " ";
            currentNode = currentNode.getNextNode();
        }
        output += "<tail>";
        System.out.println(output);
        return output;
    }

    public void addToHead(Node node) {
        Node newHead = new Node(node.getData());
        Node currentHead = this.head;
        if (currentHead != null) {
            currentHead.setPreviousNode(newHead);
            newHead.setNextNode(currentHead);
            // this.tail = currentHead;
        }
        this.head = newHead;

        if(this.tail == null) {
            this.tail = newHead;
        }
    }

    public void addToTail(Node node) {
        Node newTail = new Node(node.getData());
        Node currentTail = this.tail;

        if (currentTail != null) {
            currentTail.setNextNode(newTail);
            newTail.setPreviousNode(currentTail);
        }
        this.tail = newTail;

        if (this.head == null) {
            this.head = newTail;
        }
    }

    public String removeTail() {
        Node removedTail = this.tail;
        if (removedTail == null) {
            return null;

        }
        removedTail = removedTail.getPreviousNode();
        if (removedTail != null) {
            removedTail.setNextNode(null);
            this.tail = removedTail;
        }

        return removedTail.getData();
    }

    public Node removeByData(String data) {
        Node nodeToRemove = null;
        Node currentNode = this.head;

        while (currentNode != null) {
            if (Objects.equals(currentNode.data, data)) {
                nodeToRemove = currentNode;
                break;
            }
            currentNode = currentNode.getNextNode();
        }
        if (nodeToRemove == null) {
            return null;
        }

        if (nodeToRemove == this.head) {
//            this.removeHead();
        }
        else if (nodeToRemove == this.tail) {
            this.removeTail();
        }
        else {
            Node nextNode = nodeToRemove.getNextNode();
            Node previousNode = nodeToRemove.getPreviousNode();

            nextNode.setPreviousNode(previousNode);
            previousNode.setNextNode(nextNode);
        }

        return nodeToRemove;
    }
}


