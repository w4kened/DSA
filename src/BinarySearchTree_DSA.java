public class BinarySearchTree_DSA {
    public int value;
    public int depth;
    public BinarySearchTree_DSA left;
    public BinarySearchTree_DSA right;

    public BinarySearchTree_DSA(int value, int depth) {
        this.value = value;
        this.depth = depth;
        this.left = null;
        this.right = null;
    }

    public BinarySearchTree_DSA(int value) {
        this.value = value;
        this.depth = 1;
        this.left = null;
        this.right = null;
    }

    public void insert(int value) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = new BinarySearchTree_DSA(value, this.depth+1);
                System.out.printf("Tree node %d added to the left of %d at depth %d \n", value, this.value, this.depth + 1);
            }
            else {
                this.left.insert(value);
            }
        }
        else {
            if (this.right == null) {
                this.right = new BinarySearchTree_DSA(value, this.depth+1);
                System.out.printf("Tree node %d added to the right of %d at depth %d \n", value, this.value, this.depth + 1);
            }
            else {
                this.right.insert(value);
            }
        }
    }

    public BinarySearchTree_DSA getNodeByValue(int value) {
        if (this.value == value) {
            return this;
        } else if (value < this.value && this.left != null) {
            return this.left.getNodeByValue(value);
        } else if (value > this.value && this.right != null) {
            return this.right.getNodeByValue(value);
        }
        return null;
    }

    public void depthFirstTraversal() {
        System.out.println(this.value);

        if (this.left != null) {
            this.left.depthFirstTraversal();
        }
        if (this.right != null) {
            this.right.depthFirstTraversal();
        }
    }
}
