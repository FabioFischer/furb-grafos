
/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 04
 **
 **   Fábio Luiz Fischer
 **
 **/

public class Node<E> {
    private int index;
    private E key;
    private Node<E> nextNode;
    private Node<E> prevNode;

    public Node(int id, E key) {
        this.setIndex(id);
        this.setKey(key);
    }

    public Node(E key) {
        this.setIndex(0);
        this.setKey(key);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
