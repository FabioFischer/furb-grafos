import java.util.List;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Computação Gráfica
 **   Trabalho 01 - Questão 01
 **
 **   Fábio Luiz Fischer
 *
 **/

public interface ILinkedList<E> {
    boolean exists(E key);
    void add(E key);
    void add(List<E> list);
    void removeKey(E key);
    void removeAt(int i);
    E get(E key);
    E get(int i);
    int getCount();
}

