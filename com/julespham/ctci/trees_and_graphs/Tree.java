class Node {
    private int value; 
    private Node[] children;

    public Node(int value) {
        this.value = value;
        this.children = new Node[2];
    }
}

class TreeNode {
    public Node root;
    public TreeNode(Node root) {
        this.root = root;
    }
}

public class Tree {
    TreeNode root;
    public Tree(TreeNode root) {
        this.root = root;
    }

    public void inOrder(Tree root, int index) {
        if (root != null) {
            inOrder(root[index+1], index++);
            System.out.println(root);
            inOrder(root[index+2], index++);
        }
    } 
}

