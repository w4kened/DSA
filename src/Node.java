public class Node {

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
