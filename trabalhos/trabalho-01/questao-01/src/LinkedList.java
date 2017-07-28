
import java.util.List;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 01
 **
 **   Fábio Luiz Fischer
 *
 **/

public class LinkedList<E> implements ILinkedList<E>{

    private Node<E> firstNode;

    public LinkedList() { }

    public LinkedList(List<E> list) {
        this.add(list);
    }

    @Override
    public boolean exists(E key) {
        if (!this.isEmpty()) {
            return exists(this.getFirstNode(), key);
        }
        return false;
    }

    private boolean exists(Node node, E key) {
        if (node.getKey() == key) {
            return true;
        } else {
            return (node.getNextNode() != null) && exists(node.getNextNode(), key);
        }
    }

    private void prioritizeKey(E key) {
        this.removeKey(key);

        Node<E> prev = this.getFirstNode();

        this.setFirstNode(new Node<>(key));
        this.getFirstNode().setNextNode(prev);
    }

    private boolean isEmpty() {
        return this.getFirstNode() == null;
    }

    @Override
    public void add(E key) {
        if (this.isEmpty()) {
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
        if (!this.isEmpty()) {
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
        if (!this.isEmpty() && i >= 0) {
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
        if (!this.isEmpty() && i >= 0) {
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
    public E get(E key) {
        if (!this.isEmpty()) {
            if (this.exists(key)) {
                this.prioritizeKey(key);
                return key;
            }
        }

        return null;
    }

    @Override
    public int getCount() {
        if (!this.isEmpty()) {
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

        if (!this.isEmpty()) {
            Node<E> currNode = this.getFirstNode();

            do {
                builder.append("| ").append(currNode.getKey()).append(" |");
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
