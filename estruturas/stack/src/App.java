/**
 * Created by fabio.fischer on 27/07/2017.
 */
public class App {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(3);
        stack.push(10);

        System.out.println(stack.getSize());
        System.out.println(stack.toString());
        System.out.println(stack.getSize());
    }
}
