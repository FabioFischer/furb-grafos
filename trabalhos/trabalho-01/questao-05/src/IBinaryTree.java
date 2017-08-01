/**
 * Created by fabio.fischer on 28/07/2017.
 */
public interface IBinaryTree{
    void add(int key);
    void remove(int key);
    int size();
    int minValue();
    int maxValue();
    String toStringPreOrder();
    String toStringInOrder();
    String toStringPostOrder();
}
