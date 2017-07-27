/**
 * Created by fabio.fischer on 27/07/2017.
 */
public class App {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(10);

        System.out.println(linkedList.toString());
        System.out.println(linkedList.getCount());

        linkedList.removeKey(3);

        System.out.println(linkedList.toString());
        System.out.println(linkedList.getCount());

        linkedList.removeAt(1);

        System.out.println(linkedList.toString());
        System.out.println(linkedList.getCount());
    }
}
