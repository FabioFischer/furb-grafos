/**
 * Created by fabio.fischer on 28/07/2017.
 */
public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(3);
        tree.add(4);
        tree.add(2);
        tree.add(3);
        tree.add(10);

        System.out.println(tree.toStringPreOrder());
        System.out.println(tree.toStringInOrder());
        System.out.println(tree.toStringPostOrder());
        System.out.println(tree.size());
        System.out.println("\n");

        tree.remove(3);

        System.out.println(tree.toStringPreOrder());
        System.out.println(tree.toStringInOrder());
        System.out.println(tree.toStringPostOrder());
        System.out.println(tree.size());
        System.out.println("\n");

        tree.remove(3);

        System.out.println(tree.toStringPreOrder());
        System.out.println(tree.toStringInOrder());
        System.out.println(tree.toStringPostOrder());
        System.out.println(tree.size());
        System.out.println("\n");

        tree.remove(4);

        System.out.println(tree.toStringPreOrder());
        System.out.println(tree.toStringInOrder());
        System.out.println(tree.toStringPostOrder());
        System.out.println(tree.size());
        System.out.println("\n");
    }
}
