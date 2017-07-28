
/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Computação Gráfica
 **   Trabalho 01 - Questão 01
 **
 **   Fábio Luiz Fischer
 *
 **/

public class Node<E> {
    private E key;
    private Node<E> nextNode;

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
}
