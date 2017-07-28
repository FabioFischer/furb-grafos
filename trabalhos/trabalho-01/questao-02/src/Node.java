
/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 02
 **
 **   Fábio Luiz Fischer
 **
 **/

public class Node<E> {
    private E key;
    private Node<E> nextNode;
    private boolean deleted;

    public Node(E key) {
        this.setKey(key);
        this.setDeleted(false);
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
