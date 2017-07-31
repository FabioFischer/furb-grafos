import java.util.List;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 03
 **
 **   Fábio Luiz Fischer
 **
 **/

public interface IStack<E> {
    Node<E> pop();
    void push(E key);
    Stack<E> invertStack();
    boolean isEmpty();
    boolean verifyInput(E separator, List<E> validKeys);
}
