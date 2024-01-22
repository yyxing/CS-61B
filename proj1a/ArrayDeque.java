public class ArrayDeque<T> {
    private int size;
    private Object[] elements;
    private int capacity;
    private final double ratio = 0.25;
    private int front;
    private int tail;

    public ArrayDeque() {
        size = 0;
        capacity = 8;
        elements = new Object[capacity];
        front = 0;
        tail = 0;
    }

    private void grow() {
        Object[] old = elements;
        capacity = capacity << 1;
        elements = new Object[capacity];
        for (int i = 0; i < size; i++) {
            elements[i] = old[(front + 1 + i) % old.length];
        }
        front = capacity - 1;
        tail = size - 1;
    }

    private void decrease() {
        Object[] old = elements;
        capacity = capacity >> 1;
        elements = new Object[capacity];
        for (int i = 0; i < size; i++) {
            elements[i] = old[(front + 1 + i) % old.length];
        }
        front = capacity - 1;
        tail = size - 1;
    }

    public void addFirst(T item) {
        if (needGrow()) {
            grow();
        }
        elements[front] = item;
        front = (front + capacity - 1) % capacity;
        size++;
    }

    public void addLast(T item) {
        if (needGrow()) {
            grow();
        }
        tail = (tail + 1) % capacity;
        elements[tail] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private boolean needGrow() {
        return size == capacity;
    }

    private boolean needDecrease() {
        if (capacity == 8) {
            return false;
        }
        return size <= (capacity * ratio);
    }

    public void printDeque() {
        int c = size;
        for (int i = (front + 1); c > 0; i = (i + 1) % capacity, c--) {
            System.out.println("index: " + (i % capacity)
                    + "  item: " + elements[i % capacity].toString());
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        front = (front + 1) % capacity;
        T item = (T) elements[front];
        elements[front] = null;
        size--;
        if (needDecrease()) {
            decrease();
        }
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = (T) elements[tail];
        elements[tail] = null;
        tail = (tail + capacity - 1) % capacity;
        size--;
        if (needDecrease()) {
            decrease();
        }
        return item;
    }

    public T get(int index) {
        if (index < 0 || index >= (tail - front + capacity) % capacity) {
            return null;
        }
        return (T) elements[(front + 1 + index) % capacity];
    }

}
