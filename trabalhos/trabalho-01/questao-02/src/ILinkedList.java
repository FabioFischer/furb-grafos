import java.util.List;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 02
 **
 **   Fábio Luiz Fischer
 *
 **/

public interface ILinkedList<E> {
    boolean exists(E key);
    void add(E key);
    void add(List<E> list);
    void delete(E key);
    int countNodes();
    int countDeletedNodes();
    String toStringDeletedNodes();
    String toStringNonDeletedNodes();
}

