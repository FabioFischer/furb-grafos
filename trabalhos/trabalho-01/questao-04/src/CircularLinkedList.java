
import java.util.List;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 04
 **
 **   Fábio Luiz Fischer
 *
 **/

public class CircularLinkedList<E> implements ICircularLinkedList<E>{

    private Node<E> first;
    private int size;

    public CircularLinkedList() {
        this.setSize(0);
    }

    public CircularLinkedList(List<E> list) {
        this.add(list);
    }

    @Override
    public boolean isEmpty() {
        return this.getFirst() == null;
    }

    @Override
    public void add(E key) {
        if (this.isEmpty()) {
            this.setFirst(new Node<>(key));
            this.setSize(this.getSize()+1);
        } else {
            this.add(this.getFirst(), new Node<>(key));
        }
        this.refreshPositions();
    }

    private void add(Node<E> prev, Node<E> node) {
        if (prev.getNextNode() != null && prev.getNextNode() != this.getFirst()) {
            this.add(prev.getNextNode(), node);
        } else {
            prev.setNextNode(node);
            node.setNextNode(this.getFirst());
            node.setPrevNode(prev);
            this.getFirst().setPrevNode(node);
            this.setSize(this.getSize()+1);
        }
    }

    @Override
    public void add(List<E> list) {
        for (E key : list) {
            add(key);
        }
    }

    @Override
    public Node<E> delete(int pos) {
        Node<E> deleted = this.get(pos);

        if (this.delete(deleted.getKey())) {
            this.setSize(this.getSize()-1);
            this.refreshPositions();
        }

        return deleted;
    }

    private boolean delete(E key) {
        return !this.isEmpty() && delete(this.getFirst(), key);
    }

    private boolean delete(Node<E> node, E key) {
        if (node.getKey() != key) {
            return (node.getNextNode() != null && node.getNextNode() != this.getFirst()) && this.delete(node.getNextNode(), key);
        } else {
            if (node == this.getFirst()) {
                this.setFirst(node.getNextNode());
            }
            node.getPrevNode().setNextNode(node.getNextNode());
            node.getNextNode().setPrevNode(node.getPrevNode());

            return true;
        }
    }

    @Override
    public Node<E> get(int pos) {
        if (!this.isEmpty()) {
            return this.get(this.getFirst(), 0, pos);
        }
        return null;
    }

    private Node<E> get(Node<E> node, int index, int pos) {
        if (index != pos) {
            return (index < pos) ?
                    ((node.getNextNode() != null) ? get(node.getNextNode(), index+1, pos) : null) :
                    ((node.getPrevNode() != null) ? get(node.getPrevNode(), index-1, pos) : null);
        } else {
            return node;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (!this.isEmpty()) {
            Node<E> node = this.getFirst();

            do {
                builder.append("| ").append(node.getIndex()).append("-> ").append(node.getKey());
            } while ((node = node.getNextNode()) != null && node != this.getFirst());
        }

        return builder.toString();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void refreshPositions() {
        if (!this.isEmpty()) {
            this.refreshPositions(this.getFirst(), 0);
        }
    }

    private void refreshPositions(Node<E> node, int index) {
        node.setIndex(index);
        if (node.getNextNode() != null && node.getNextNode() != this.getFirst()) {
            this.refreshPositions(node.getNextNode(), index+1);
        }
    }

    public Node<E> getFirst() {
        return first;
    }

    public void setFirst(Node<E> first) {
        this.first = first;
    }
}
