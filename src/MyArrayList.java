
public class MyArrayList<T> implements List<T> {

    private int size = 0;
    private int currentCapacity = DEFAULT_CAPACITY_STEP;
    private static final int DEFAULT_CAPACITY_STEP = 16;
    private Object[] array = new Object[currentCapacity];
    private int iteratorValue = 0;

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
    public boolean containsAll(List<T> c) {
        for (int i = 0; i < c.size(); i++) {
            if (!contains(c.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void add(Object o) {
        extend();
        array[size] = o;
        size++;
    }

    @Override
    public void addAll(List<T> c) {
        extendAll(c.size() + size);
        for (int i = 0; i < c.size(); i++) {
            add(c.get(i));
        }
    }

    @Override
    public int remove(Object o) {
        int numberOfRemoves = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == o) {
                remove(i--);
                numberOfRemoves++;
            }
        }
        return numberOfRemoves;
    }

    @Override
    public Object remove(int index) {
        Object o = array[index];
        while (index < size) {
            set(index, get(++index));
        }
        set(--size, null);
        reduction();
        return o;
    }

    @Override
    public void removeAll(List<T> c) {
        for (int i = 0; i < c.size(); i++) {
            Object object = c.get(i);
            remove(object);
        }
        reductionAll();
    }

    @Override
    public void clear() {
        array = new Object[DEFAULT_CAPACITY_STEP];
        currentCapacity = DEFAULT_CAPACITY_STEP;
        size = 0;
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public void set(int index, Object o) {
        array[index] = o;
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
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public Object iterator() {
        if (iteratorValue == size) {
            iteratorValue = 0;
        }
        return array[iteratorValue++];
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
