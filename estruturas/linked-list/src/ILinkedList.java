import java.util.List;
/**
 * Created by fabio.fischer on 27/07/2017.
 */
public interface ILinkedList<E> {
    void add(E key);
    void add(List<E> list);
    void removeKey(E key);
    void removeAt(int i);
    E get(int i);
    int getCount();
}

