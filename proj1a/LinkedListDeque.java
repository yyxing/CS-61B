
public class LinkedListDeque<T> implements Deque<T>{

    int size;
    Node<T> tail;
    Node<T> head;
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    public LinkedListDeque() {
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        if (head == null) {
            head = new Node<>(null, item, null);
            size++;
            return;
        }
        head = new Node<>(null, item, head);
        size++;
    }

    @Override
    public void addLast(T item) {
        if (tail == null) {
            tail = new Node<>(null, item, null);
            size++;
            return;
        }
        tail = new Node<>(tail, item, null);
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {

    }

    @Override
    public T removeFirst() {
        Node<T> node = head;
        head = head.next;
        size--;
        return node.item;
    }

    @Override
    public T removeLast() {
        Node<T> node = tail;
        tail = tail.prev;
        size--;
        return node.item;
    }

    @Override
    public T get(int index) {
        int c = 0;
        Node<T> node = head;
        while (node != null) {
            c++;
            node = node.next;
            if (c == index) {
                return node.item;
            }
        }
        return null;
    }

    public T getRecursive(int index) {
        int c = 0;
        Node<T> node = tail;
        while (node != null) {
            c++;
            node = node.prev;
            if (c == index) {
                return node.item;
            }
        }
        return null;
    }
}
