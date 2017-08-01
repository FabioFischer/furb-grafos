import java.util.List;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 04
 **
 **   Fábio Luiz Fischer
 **/

public interface ICircularLinkedList<E> {
    boolean isEmpty();
    void add(E key);
    void add(List<E> list);
    Node<E> get(int pos);
    Node<E> delete(int pos);
}

