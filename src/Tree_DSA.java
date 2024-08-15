public class Tree_DSA {

    // Instance variable here
    public TreeNode root;
    // Constructor here
    public Tree_DSA(TreeNode root) {
        this.root = root;
    }


    public void print() {
        print(this.root, 0);
    }

    public void print(TreeNode current, int level) {
        String levelMarks = "";
        for (int i = 0; i < level; i++) {
            levelMarks += "-- ";
        }
        System.out.println(levelMarks + current.data);
        for (TreeNode child : current.children) {
            print(child, level + 1);
        }
    }
}