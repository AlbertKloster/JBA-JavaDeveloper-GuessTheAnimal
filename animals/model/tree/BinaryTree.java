package animals.model.tree;

public class BinaryTree {
    Node root;

    public void updateNode(Node current, Node node) {
        current.value = node.value;
        current.yes = node.yes;
        current.no = node.no;
    }

    public void setRoot(Node node) {
        root = node;
    }

    public Node getRoot() {
        return root;
    }

    public Node getNext(Node current, boolean yes) {
        if (current.yes == null)
            return null;
        return yes ? current.yes : current.no;
    }

}
