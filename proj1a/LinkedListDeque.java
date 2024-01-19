import java.util.ArrayList;

public class LinkedListDeque<T>{

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
        }else {
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
        }else {
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
        if (head == null) return null;
        T item = head.item;
        head = head.next;
        size--;
        return item;
    }

    public T removeLast() {
        if (tail == null) return null;
        T item = tail.item;
        tail = tail.prev;
        size--;
        return item;
    }

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
