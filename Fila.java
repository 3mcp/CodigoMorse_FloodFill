public class Fila<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;


    public Fila(int size) {
        this.data = (T[]) new Object[size];
    }

    public void add(T s) {
        if (isFull()) {
            throw new RuntimeException("Fila cheia");
        }
        top = (top + 1) % data.length;
        data[top] = s;
    }

    public T remove() {
        if (isEmpty()) {
            throw new RuntimeException("Fila vazia");
        }
        T item = data[base];
        base = (base + 1) % data.length;
        return item;
    }

    public void clear() {
        top = -1;
        base = 0;
        data = (T[]) new Object[data.length];
    }

    public boolean isFull() {
        return (top + 1) % data.length == base && data[base] != null;
    }

    public boolean isEmpty() {
        return top == -1 || (base == (top + 1) % data.length && data[base] == null);
    }
}