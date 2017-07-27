
import java.util.List;

/**
 * Created by fabio.fischer on 27/07/2017.
 */

public class LinkedList<E> implements ILinkedList<E>{

    private Node<E> firstNode;

    public LinkedList() {
        this.setFirstNode(null);
    }

    public LinkedList(List<E> list) {
        this.add(list);
    }

    @Override
    public void add(E key) {
        if (this.getFirstNode() == null) {
            this.setFirstNode(new Node<>(key));
        } else {
            this.add(this.getFirstNode(), new Node<>(key));
        }
    }

    private void add(Node<E> prevNode, Node<E> node) {
        if (prevNode.getNextNode() == null) {
            prevNode.setNextNode(node);
        } else {
            add(prevNode.getNextNode(), node);
        }
    }

    @Override
    public void add(List<E> list) {
        for (E key : list) {
            add(key);
        }
    }

    @Override
    public void removeKey(E key) {
        if (this.getFirstNode() != null) {
            Node<E> prevNode = null;
            Node<E> currNode = this.getFirstNode();

            do {
                if (currNode.getKey() == key) {
                    if (prevNode == null) {
                        this.setFirstNode(currNode.getNextNode());
                    } else {
                        this.remove(prevNode, currNode);
                    }
                }
                prevNode = currNode;

            } while ((currNode = currNode.getNextNode()) != null);
        }
    }

    @Override
    public void removeAt(int i) {
        if (this.getFirstNode() != null && i >= 0) {
            if (i == 0) {
                this.setFirstNode(this.getFirstNode().getNextNode());
            } else {
                int index = 0;

                Node<E> prevNode;
                Node<E> currNode = this.getFirstNode();

                do {
                    prevNode = currNode;
                    currNode = currNode.getNextNode();
                    index++;
                } while (index < i);

                remove(prevNode, currNode);
            }
        }
    }

    private void remove(Node<E> prevNode, Node<E> node) {
        prevNode.setNextNode(node.getNextNode());
    }

    @Override
    public E get(int i) {
        if (this.getFirstNode() != null && i >= 0) {
            if (i == 0) {
                return this.getFirstNode().getKey();
            }
            int index = 0;
            Node<E> node = this.getFirstNode();

            do {
                node = node.getNextNode();
                index++;
            } while(index < i);

            return node.getKey();
        }
        return null;
    }

    @Override
    public int getCount() {
        if (this.getFirstNode() != null) {
            return getCount(this.getFirstNode());
        }
        return 0;
    }

    private int getCount(Node<E> node) {
        if (node.getNextNode() != null) {
            return 1 + getCount(node.getNextNode());
        }
        return 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (this.getFirstNode() != null) {
            Node<E> currNode = this.getFirstNode();

            do {
                builder.append("| " + currNode.getKey());
            } while ((currNode = currNode.getNextNode()) != null);
        }

        return builder.toString();
    }

    public Node<E> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(Node<E> firstNode) {
        this.firstNode = firstNode;
    }
}
