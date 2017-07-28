import java.util.List;

/**
 * Created by fabio.fischer on 27/07/2017.
 */
public class DoublyLinkedList<E> implements IDoublyLinkedList<E> {
    private Node<E> firstNode;

    public DoublyLinkedList() {}

    public DoublyLinkedList(List<E> list) {
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

    @Override
    public void add(List<E> list) {
        for (E key : list) {
            this.add(key);
        }
    }

    private void add(Node<E> curr, Node<E> node) {
        if (curr.getNextNode() != null) {
            this.add(curr.getNextNode(), node);
        } else {
            curr.setNextNode(node);
            node.setPrevNode(curr);
        }
    }

    @Override
    public void removeKey(E key) {
        if (this.getFirstNode() != null) {
            Node<E> node = this.getFirstNode();

            do {
                if (node.getKey() == key) {
                    this.remove(node);
                }
            } while ((node = node.getNextNode()) != null);
        }
    }

    @Override
    public void removeAt(int i) {
        if (this.getFirstNode() != null && i >= 0) {
            remove(this.get(i));
        }
    }

    private void remove(Node<E> node) {
        if (node.getPrevNode() == null) {
            this.setFirstNode(node.getNextNode());
            this.getFirstNode().setPrevNode(null);
        } else {
            node.getPrevNode().setNextNode(node.getNextNode());
            node.getNextNode().setPrevNode(node.getPrevNode());
        }
    }

    @Override
    public E getAt(int i) {
        if (this.getFirstNode() != null && i >= 0) {
            return this.get(i).getKey();
        }
        return null;
    }

    private Node<E> get(int i) {
        Node<E> node = this.getFirstNode();
        int index = 0;

        while (index >= i) {
            node = node.getNextNode();
            index++;
        }

        return node;
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
