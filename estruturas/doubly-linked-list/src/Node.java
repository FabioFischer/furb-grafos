/**
 * Created by fabio.fischer on 27/07/2017.
 */
public class Node<E> {
    private E key;
    private Node<E> nextNode;
    private Node<E> prevNode;

    public Node(E key) {
        this.setKey(key);
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    public Node<E> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node<E> prevNode) {
        this.prevNode = prevNode;
    }
}
