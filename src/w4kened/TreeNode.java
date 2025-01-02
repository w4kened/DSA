package w4kened;

import java.util.ArrayList;

public class TreeNode {

    public Object data;
    public ArrayList<TreeNode> children;

    public TreeNode(Object data) {
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }
    public void addChild(Object childData) {
        children.add(new TreeNode(childData));
    }

    public void removeChild(TreeNode childToRemove) {
        if (this.children.isEmpty()) {
            System.out.println("base case");
            return;
        } else if (this.children.contains(childToRemove)) {
            System.out.println("removing case");
            this.children.remove(childToRemove);
            return;
        } else {
            //recursive case
            System.out.println("recursive/fork case");
            for (TreeNode child : this.children) {
                child.removeChild(childToRemove);
            }
        }
    }

    public void removeChild(Object targetData) {
        if (this.children.isEmpty()) {
            System.out.println("base case");
            return;
        }
        for (TreeNode child : this.children) {
            if (child.data == targetData) {
                System.out.println("removing case");
                this.children.remove(child);
                return;
            }
        }
        for (TreeNode child : this.children) {
            child.removeChild(targetData);
        }
    }


}
