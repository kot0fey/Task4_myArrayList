import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    private int size = 0;
    private int currentCapacity = DEFAULT_CAPACITY_STEP;
    private static final int DEFAULT_CAPACITY_STEP = 16;
    private Object[] array = new Object[currentCapacity];

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i] == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size && array[index] != null;
            }
            @Override
            public T next() {
                return (T) array[index++];
            }
            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {//////////////////////////////////////////
        return null;
    }

    @Override
    public boolean add(T t) {
        extend();
        array[size] = t;
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        boolean removeFlag = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == o) {
                remove(i--);
                removeFlag = true;
            }
        }
        return removeFlag;
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
        extendAll(c.size() + size);
        for (T o : c) {
            add(o);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {//////////////////////
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            remove(o);
        }
        reductionAll();
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {////////////////////////////
        return false;
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_CAPACITY_STEP];
        currentCapacity = DEFAULT_CAPACITY_STEP;
        size = 0;
    }

    @Override
    public T get(int index) {
        return (T) array[index];
    }

    @Override
    public T set(int index, T element) {
        array[index] = element;
        return element;
    }

    @Override
    public void add(int index, T element) {///////////////////////////////////////////

    }

    @Override
    public T remove(int index) {
        T o = (T) array[index];
        while (index < size) {
            set(index, get(++index));
        }
        set(--size, null);
        reduction();
        return o;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {////////////////////////
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {//////////////////
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {///////////////////////////////
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {//////////////////////////////
        return null;
    }

    public MyArrayList() {

    }

    public MyArrayList(List<T> c) {
        addAll(c);
    }

    public MyArrayList(int capacity) {
        currentCapacity = capacity;
    }

    private void extend() {
        if (currentCapacity == size) {
            currentCapacity += DEFAULT_CAPACITY_STEP;
            Object[] newArray = new Object[currentCapacity];
            System.arraycopy(array, 0, newArray, 0, currentCapacity);
            array = newArray;
        }
    }

    private void extendAll(int finalSize) {
        while (finalSize > currentCapacity) {
            extend();
        }
    }

    private void reduction() {
        if (size <= currentCapacity - DEFAULT_CAPACITY_STEP) {
            currentCapacity -= DEFAULT_CAPACITY_STEP;
            Object[] newArray = new Object[currentCapacity];
            System.arraycopy(array, 0, newArray, 0, currentCapacity);
            array = newArray;
        }
    }

    private void reductionAll() {
        while (size < currentCapacity - DEFAULT_CAPACITY_STEP) {
            reduction();
        }
    }

    public void print() {
        System.out.print("MyArrayList contains: {");
        if (size != 0) {
            for (int i = 0; i < size - 1; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.print(array[size - 1]);
        }
        System.out.println("}");
    }
}
