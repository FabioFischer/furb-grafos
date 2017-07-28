
import java.util.List;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 02
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
        return node.getKey() == key || (node.getNextNode() != null) && exists(node.getNextNode(), key);
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

    private void add(Node<E> prev, Node<E> node) {
        if (prev.getNextNode() == null) {
            prev.setNextNode(node);
        } else {
            add(prev.getNextNode(), node);
        }
    }

    @Override
    public void add(List<E> list) {
        for (E key : list) {
            add(key);
        }
    }

    @Override
    public void delete(E key) {
        if (!this.isEmpty()) {
            Node<E> curr = this.getFirstNode();

            do {
                if (curr.getKey() == key && !curr.isDeleted()) {
                    curr.setDeleted(true);
                }
            } while ((curr = curr.getNextNode()) != null);

            this.checkLazyDeletion();
        }
    }

    private void checkLazyDeletion() {
        if (!this.isEmpty()) {
            if (this.countDeletedNodes() >= this.countNodes()) {
                System.out.println("          ~~Executando lazy deletion~~");
                this.lazyDeletion();
            }
        }
    }

    private void lazyDeletion() {
        Node<E> prev = null;
        Node<E> curr = this.getFirstNode();

        do {
            if (curr.isDeleted()) {
                if (prev == null) {
                    this.setFirstNode(curr.getNextNode());
                } else {
                    prev.setNextNode(curr.getNextNode());
                }
            } else {
                prev = curr;
            }

        } while ((curr = curr.getNextNode()) != null);
    }

    @Override
    public int countNodes() {
        if (!this.isEmpty()) {
            return countNodes(this.getFirstNode());
        }
        return 0;
    }

    private int countNodes(Node<E> node) {
        if (node.getNextNode() != null) {
            return (node.isDeleted() ? 0 : 1) + countNodes(node.getNextNode());
        }
        return (node.isDeleted() ? 0 : 1);
    }

    @Override
    public int countDeletedNodes() {
        if (!this.isEmpty()) {
            return countDeletedNodes(this.getFirstNode());
        }
        return 0;
    }

    private int countDeletedNodes(Node<E> node) {
        if (node.getNextNode() != null) {
            return (!node.isDeleted() ? 0 : 1) + countDeletedNodes(node.getNextNode());
        }
        return (!node.isDeleted() ? 0 : 1);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (!this.isEmpty()) {
            Node<E> curr = this.getFirstNode();

            do {
                builder.append("| ").append(curr.getKey()).append(" |");
            } while ((curr = curr.getNextNode()) != null);
        }

        return builder.toString();
    }

    @Override
    public String toStringDeletedNodes() {
        StringBuilder builder = new StringBuilder();

        if (!this.isEmpty()) {
            Node<E> curr = this.getFirstNode();

            do {
                if (curr.isDeleted()) builder.append("| ").append(curr.getKey()).append(" |");
            } while ((curr = curr.getNextNode()) != null);
        }

        return builder.toString();
    }

    @Override
    public String toStringNonDeletedNodes() {
        StringBuilder builder = new StringBuilder();

        if (!this.isEmpty()) {
            Node<E> curr = this.getFirstNode();

            do {
                if (!curr.isDeleted()) builder.append("| ").append(curr.getKey()).append(" |");
            } while ((curr = curr.getNextNode()) != null);
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
