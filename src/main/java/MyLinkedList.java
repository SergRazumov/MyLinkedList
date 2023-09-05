import java.util.*;

class MyLinkedList<E> implements Collection<E> {

    private int size = 0;

    private Node<E> first;

    private Node<E> last;


    private static class Node<E> {
        private final E item;
        private Node<E> next;
        private Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }


        public String toString() {
            return item.toString();
        }
    }

    private class IteratorLinkedList implements Iterator<E> {

        private Node<E> current = first;


        public boolean hasNext() {
            return current != null;
        }


        public E next() {
            final E currentObj = current.item;
            current = current.next;
            return currentObj;
        }
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size() == 0;
    }


    public boolean contains(Object o) {
        for (Node<E> current = first; current != null; current = current.next) {
            if (current.item.equals(o)) return true;
        }
        return false;
    }


    public Iterator<E> iterator() {
        return new IteratorLinkedList();
    }


    public Object[] toArray() {
        Object[] result = new Object[size];
        for (Node<E> current = first; current != null; current = current.next) {
            Arrays.fill(result, current);
        }
        return result;
    }


    public <T> T[] toArray(T[] a) {
        for (Node<E> current = first; current != null; current = current.next) {
            Arrays.fill(a, current.item);
        }
        return a;
    }


    public boolean add(E e) {
        Node<E> node;
        if (first == null) {
            node = new Node<>(null, e, null);
            first = node;
        } else {
            node = new Node<>(last, e, null);
            last.next = node;
        }
        last = node;
        size++;
        return true;
    }


    public boolean remove(Object o) {
        if (size == 0) return false;
        if (first == last && first.item.equals(o)) {
            first = null;
            last = null;
            size = 0;
            return true;
        }
        for (Node<E> current = first; current != null; current = current.next) {
            if (current.item.equals(o)) {
                if (current == first) {
                    current.next.prev = null;
                    first = current.next;
                    current.next = null;
                } else if (current == last) {
                    current.prev.next = null;
                    last = current.prev;
                    current.prev = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current.next = null;
                    current.prev = null;

                }
                size--;
                return true;
            }
        }
        return false;
    }


    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e))
                return false;
        }
        return true;
    }


    public boolean addAll(Collection<? extends E> c) {
        return addAll(size, c);
    }


    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size) {
            return false;
        }
        if (size() == 0 || index == size()) {
            for (E e : c) {
                add(e);
            }
        } else {
            Node<E> current = first;
            Node<E> loopCurrent = null;
            int i = 0;
            do {
                loopCurrent = current;
                current = current.next;
                i++;
            } while (i == index - 1);
            for (E e : c) {
                Node<E> node = new Node<>(loopCurrent, e, null);
                loopCurrent.next = node;
                loopCurrent = node;
                size++;
            }
            current.prev = loopCurrent;
            loopCurrent.next = current;
        }

        return true;
    }


    public boolean removeAll(Collection<?> c) {
        for (Object e : c) {
            if (!remove(e)) return false;
        }
        return true;
    }


    public boolean retainAll(Collection<?> c) {
        for (Node<E> current = first; current != null; current = current.next) {
            if (!c.contains(current.item)) {
                remove(current.item);
            }
        }
        return true;
    }


    public void clear() {
        first = null;
        last = null;
        size = 0;
    }


}