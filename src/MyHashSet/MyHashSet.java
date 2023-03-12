package MyHashSet;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class MyHashSet<T> implements Set {

    private int size = 0;

    private Node<T>[] table = new Node[DEFAULT_CAPACITY];

    private static final int DEFAULT_CAPACITY = 16;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object data) {
        int hash = Math.abs(data.hashCode()) % DEFAULT_CAPACITY;
        if (table[hash] != null) {
            return table[hash].contains(data);
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> currentElement = setCurrentElement();

            private Node<T> setCurrentElement() {

                for (Node<T> element : table) {
                    if (element != null) {
                        return element;
                    }
                }

                return null;
            }

            private Node<T> setCurrentElement(Node<T> currentElement) {
                if (currentElement.getHash() + 1 == DEFAULT_CAPACITY) {//////////////////////
                    return null;
                }

                for (int i = currentElement.getHash() + 1; i < DEFAULT_CAPACITY; i++) {
                    if (table[i] != null) {
                        return table[i];
                    }
                }

                return null;
            }

            @Override
            public boolean hasNext() {
                return currentElement != null;
            }

            @Override
            public T next() {
                T data = currentElement.getData();
                if (currentElement.getNext() == null) {
                    currentElement = setCurrentElement(currentElement);
                } else {
                    currentElement = currentElement.getNext();
                }
                return data;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Object o : this) {
            array[i++] = o;
        }

        return array;
    }

    @Override
    public boolean add(Object data) {
        if (contains(data)) {
            return false;
        }

        int hash = Math.abs(data.hashCode()) % DEFAULT_CAPACITY;
        if (table[hash] == null) {
            table[hash] = new Node<T>(data);
        } else {
            table[hash].setLast(data);
        }

        size++;
        return true;
    }

    @Override
    public boolean remove(Object data) {
        if (!contains(data)) {
            return false;
        }
        int hash = Math.abs(data.hashCode()) % DEFAULT_CAPACITY;

        if (table[hash].findPrev(data) != null) {
            table[hash].findPrev(data).setNext(table[hash].findPrev(data).getNext().getNext());
        } else {
            table[hash] = table[hash].getNext();
        }

        size--;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object data : c) {
            add(data);
            size++;
        }

        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object data : c) {
            remove(data);
            size--;
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {//////////////////////////////////////////////////
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object data : c) {
            if (contains(data) == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {///////////////////////
        return new Object[0];
    }
}
