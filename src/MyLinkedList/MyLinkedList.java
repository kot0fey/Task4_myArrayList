package MyLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {

    private int size = 0;
    Node<T> first;
    Node<T> last;

    public void addFirst(T data) {
        Node<T> element = new Node<>(data);
        element.next = first;
        first = element;
        if (size == 0) {
            last = element;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> element = new Node<>(data);
        last.next = element;
        last = element;
        if (size == 0) {
            first = element;
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> checkingElement = first;
        for (int i = 0; i < size; i++) {
            if (checkingElement == o) {
                return true;
            }
            checkingElement = checkingElement.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> currentElement = first;

            @Override
            public boolean hasNext() {
                return currentElement.next != null;
            }

            @Override
            public T next() {
                currentElement = currentElement.next;
                return (T) currentElement;
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
        Node<T> currentElement = first;
        for (int i = 0; i < size; i++) {
            array[i] = currentElement;
            currentElement = currentElement.next;
        }
        return array;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {//////////////////////////////////
        return null;
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        boolean removeFlag = index > -1;

        if (!removeFlag) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T o : c) {
            add(o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {////////////////////
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {//////////////////////////////////////
        return false;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public T get(int index) {
        Node<T> currentElement = first;
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        return currentElement.data;
    }

    @Override
    public T set(int index, T element) {
        Node<T> currentElement = first;
        for (int i = 0; i < index; i++) {
            currentElement = currentElement.next;
        }
        currentElement.data = element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        addFirst(element);
        if (index == 0 || index > size) {
            addFirst(element);
            return;
        }
        if (index == size) {
            addLast(element);
            return;
        }
        addFirst(element);
        Node<T> newElement = first;
        Node<T> nextElement = newElement.next;
        Node<T> prevElement = null;


        newElement.next = newElement.next.next;//For first iteration
        nextElement.next = newElement;
        first = nextElement;
        nextElement = newElement.next;
        prevElement = first;

        for (int i = 0; i < index - 1; i++) {
            if (newElement.next.next == last) {
                newElement.next = null;
            } else {
                newElement.next = newElement.next.next;
            }
            nextElement.next = newElement;
            prevElement.next = nextElement;

            nextElement = newElement.next;
            prevElement = prevElement.next;
        }
    }

    @Override
    public T remove(int index) {
        Node<T> checkingElement = first;
        for (int i = 0; i < index - 1; i++) {
            checkingElement = checkingElement.next;
        }
        T returnStatement = checkingElement.next.data;
        if (checkingElement.next != null) {
            checkingElement.next = checkingElement.next.next;
        } else {
            checkingElement.next = null;
        }
        size--;
        return returnStatement;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<T> element = first;
        while (element.next != null) {
            if (element.data == o) {
                return index;
            }
            element = element.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {////////////////////////////////////
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {////////////////////////////////////
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {/////////////////////////////////////////////////
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {///////////////////////////////////////////////
        return null;
    }
}