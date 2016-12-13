/**
 * Created by natna on 11/24/2016.
 */
public class Tree {

    Node root;


    public Tree() {
        root = null;

    }

    public void insert(int value) {

        if (root == null) root = new Node(value);
        else root.insertNode(value);
    }

    public int sumAllValues() {
        int sum = 0;
        if (root != null) sum += root.sumAllValues(root);
        root.sum = 0;
        return sum;
    }


    public Node find(int value) {
        Node find = root;
        while (find != null) {
            if (find.value == value) {
                return find;
            } else if (find.value > value) {
                find = find.left;
            } else {
                find = find.right;
            }
        }
        return null;
    }


} //end of class tree



