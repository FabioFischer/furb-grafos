import java.util.List;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 03
 **
 **   Fábio Luiz Fischer
 **
 **/

public class Stack<E> implements IStack<E>, Cloneable {
    private Node<E> top;
    private int size;

    public Stack() {
        this.setSize(0);
    }

    public Stack(E[] array) {
        this.add(array);
    }

    public Stack(List<E> list) {
        this.add(list);
    }

    @Override
    public void push(E key) {
        if (this.isEmpty()) {
            this.setTop(new Node<>(key));
            this.setSize(this.getSize() + 1);
        } else {
            this.add(new Node<>(key));
        }
    }

    @Override
    public Node<E> pop() {
        if (!this.isEmpty()) {
            Node<E> currTop = this.getTop();
            this.setTop(currTop.getNext());
            this.setSize(this.getSize() - 1);

            return currTop;
        }
        return null;
    }

    @Override
    public Stack<E> invertStack() {
        try {
            Stack<E> clone = (Stack<E>) this.clone();
            Stack<E> inverted = new Stack<>();
            Node<E> curr;

            while ((curr = clone.pop()) != null) {
                inverted.push(curr.getKey());
            }
            return inverted;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.getTop() == null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        try {
            Stack<E> clone = (Stack<E>) this.clone();

            if (!clone.isEmpty()) {
                Node<E> curr;

                while ((curr = clone.pop()) != null) {
                    builder.append("| " + curr.getKey());
                }
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    private void add(List<E> list) {
        for (E key : list) {
            this.push(key);
        }
    }

    private void add(E[] array) {
        for (E key : array) {
            this.push(key);
        }
    }

    private void add(Node<E> node) {
        node.setNext(this.getTop());
        this.setTop(node);
        this.setSize(this.getSize() + 1);
    }

    @Override
    public boolean verifyInput(E separator, List<E> validKeys) {
        if (!this.isEmpty()) {
            try {
                Stack<E> clone = (Stack<E>)this.clone();
                Stack<E> s1 = new Stack<>(), s2 =  new Stack<>();
                Node<E> curr;

                int sepCount = 0;

                while ((curr = clone.pop()) != null) {
                    if (curr.getKey() == separator) {
                        sepCount++;
                    } else if (!validKeys.contains(curr.getKey())) {
                        return false;
                    } else if (sepCount == 0) {
                        s1.push(curr.getKey());
                    } else {
                        s2.push(curr.getKey());
                    }
                }

                return (sepCount == 1) && (s1.getSize() == s2.getSize()) && equals(s1, s2.invertStack());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    private boolean equals(Stack<E> s1, Stack<E> s2) {
        Node<E> n1, n2;

        while ((n1 = s1.pop()) != null && (n2 = s2.pop()) != null) {
            if (n1.getKey() != n2.getKey()) {
                return false;
            }
        } return true;
    }

    public Node<E> getTop() {
        return top;
    }

    public void setTop(Node<E> top) {
        this.top = top;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
