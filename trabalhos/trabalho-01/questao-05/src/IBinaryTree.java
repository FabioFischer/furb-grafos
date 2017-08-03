
/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 05
 **
 **   Fábio Luiz Fischer
 *
 **/

public interface IBinaryTree{
    void add(Node node);
    void add(Node parent, Node node, Node.NodeDirection direction);
    void remove(int key);
    int getHeight();
    int getWidth();
    int size();
    int minValue();
    int maxValue();
    int sumPile(int pile);
    int sumPiles();
    String toStringPreOrder();
    String toStringInOrder();
    String toStringPostOrder();
}
