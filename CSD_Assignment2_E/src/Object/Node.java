
package Object;

public class Node {
    public Train data;
    public Node left, right;
    public int height;

    public Node(Train data) {
        this.data = data;
        this.height = 1; // Initial height for AVL balancing
    }
}
