/**
 * Created by fabio.fischer on 27/07/2017.
 */
public interface IStack<E> {
    void push(E key);
    boolean isEmpty();
    Node<E> pop();
}
