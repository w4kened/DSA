public class LinkedList_DSA {
    public Node head;

    public LinkedList_DSA() {
        this.head = null;
    }

    public void addToHead(Node node) {
        Node newNode = new Node(node.getData());
        Node currentNode = this.head;
        this.head = newNode;

        if (currentNode != null) {
            this.head.setNextNode(currentNode);
        }
    }

    public void addToTail(Node node) {
        Node newNode = new Node(node.getData());
        Node currentNode = this.head;

        if (currentNode == null) {
            this.head = newNode;
        } else {
            while (currentNode.getNextNode() != null) {
                currentNode = currentNode.getNextNode();
            }
            currentNode.setNextNode(newNode);
        }
    }


    public String removeHead() {
        if (this.head != null) {
            Node removedHead = this.head;
            this.head = removedHead.getNextNode();

            return removedHead.getData();
        }
        return null;
    }

    private Node getPreviousNode(Node node) {

        for (Node itNode = this.head; itNode != node; itNode = itNode.getNextNode()) {
            if (itNode.getNextNode().equals(node)) {
                return itNode;
            }
        }
        return null;
    }

    public String removeNodeByData(String data) throws NullPointerException {
        Node currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.getData().equals(data)) {
                Node nextNode = currentNode.getNextNode();
                Node previousNode = getPreviousNode(currentNode);
                previousNode.setNextNode(nextNode);
                return currentNode.getData(); //return deleted
            }
            currentNode = currentNode.getNextNode();
        }
        return ""; //return deleted
    }

    public void printList() {
        Node currentNode = this.head;
        String output = "<head> ";

        while (currentNode != null) {
            output += currentNode.getData() + " / ";
            currentNode = currentNode.getNextNode();
        }
        output += " <tail>";
        System.out.println(output);
    }

        private static Integer getSize(LinkedList_DSA linkedList) {
            Node currentNode = linkedList.head;
            Integer counter = 0;
            while (currentNode != null) {
                counter++;
                currentNode = currentNode.getNextNode();
            }
            return counter;
        }

        public static Node findMiddle(LinkedList_DSA linkedList) {
            Node currentNode = linkedList.head;
            Integer counter = 0;
            Integer middle = (getSize(linkedList)/2) + 1;

            Node lastNode = null;
            while (counter < middle) {
                lastNode = currentNode;
                currentNode = currentNode.getNextNode();
                counter++;

            }
            return lastNode;
        }
}





