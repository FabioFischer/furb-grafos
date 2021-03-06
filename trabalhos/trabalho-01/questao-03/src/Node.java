
/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 03
 **
 **   Fábio Luiz Fischer
 **
 **/

public class Node<E> {
    private E key;
    private Node<E> next;

    public Node(E key) {
        this.setKey(key);
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}
