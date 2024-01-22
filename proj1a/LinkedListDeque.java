public class LinkedListDeque<T> {

    private int size;
    private Node<T> tail;
    private Node<T> head;

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

    public void addFirst(T item) {
        Node<T> h = head;
        Node<T> node = new Node<>(null, item, h);
        head = node;
        if (h == null) {
            tail = node;
        } else {
            h.prev = node;
        }
        size++;
    }

    public void addLast(T item) {
        Node<T> t = tail;
        Node<T> node = new Node<>(t, item, null);
        tail = node;
        if (t == null) {
            head = node;
        } else {
            t.next = node;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {

    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = head.item;
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = tail.item;
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }
        size--;
        return item;
    }

    public T get(int index) {
        int c = 0;
        Node<T> node = head;
        while (node != null) {
            if (c == index) {
                return node.item;
            }
            c++;
            node = node.next;
        }
        return null;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecursiveHelper(head, index);
    }

    private T getRecursiveHelper(Node<T> node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
}
