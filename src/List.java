
public interface List<T> {
    int size();

    boolean isEmpty();

    boolean contains(Object o);

    boolean containsAll(List<T> c);

    void add(Object o);

    void addAll(List<T> c);

    int remove(Object o);

    Object remove(int index);

    void removeAll(List<T> c);

    void clear();

    Object get(int index);

    void set(int index, Object o);

    int indexOf(Object o);

    Object[] toArray();

    Object iterator();

    void print();
}
