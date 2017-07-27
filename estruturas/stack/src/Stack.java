import java.util.List;

/**
 * Created by fabio.fischer on 27/07/2017.
 */
public class Stack<E> implements IStack<E> {
    private Node<E> top;
    private int size;

    public Stack() {
        this.setSize(0);
    }

    public Stack(List<E> list) {
        this.add(list);
    }

    @Override
    public void push(E key) {
        if (this.isEmpty()) {
            this.setTop(new Node<>(key));
            this.setSize(this.getSize() + 1);
        } else {
            this.add(new Node<>(key));
        }
    }

    @Override
    public Node<E> pop() {
        if (!this.isEmpty()) {
            Node<E> currTop = this.getTop();
            this.setTop(currTop.getNext());
            this.setSize(this.getSize() - 1);

            return currTop;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.getTop() == null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (!this.isEmpty()) {
            Node<E> currNode;

            while((currNode = this.pop()) != null) {
                builder.append("| " + currNode.getKey());
            }
        }
        return builder.toString();
    }

    private void add(List<E> list) {
        for (E key : list) {
            this.push(key);
        }
    }

    private void add(Node<E> node) {
        node.setNext(this.getTop());
        this.setTop(node);
        this.setSize(this.getSize() + 1);
    }

    public Node<E> getTop() {
        return top;
    }

    public void setTop(Node<E> top) {
        this.top = top;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
