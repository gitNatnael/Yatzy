/**
 * Created by natna on 11/24/2016.
 */
public class Node {

    int value;
    int freq;
    long sum;
    Node left;
    Node right;


    public Node(int value) {

        this.value = value;
        this.left = null;
        this.right = null;
        freq = 1;
        sum=0;
    }


    public void insertNode(int value) {

        if (value == this.value) this.freq++;
        else {

            if (value < this.value) {
                if (this.left == null)
                    this.left = new Node(value);
                else
                    this.left.insertNode(value);
            } else if (this.right == null)
                this.right = new Node(value);
            else
                this.right.insertNode(value);

        }

    }



    public long sumAllValues(Node root) {

        if (root != null) {

            sumAllValues(root.left);
            sum += root.value * root.freq;
            sumAllValues(root.right);
        }

        return sum;
    }


    public String toString() {
        return this.value + "\t\t it occurs in the tree :\t" + this.freq + " times";
    }


}
