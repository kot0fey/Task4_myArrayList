package MyMap;

import java.util.*;

public class MyMap<K, V> implements Map {

    private int size = 0;

    private Node<K, V>[] table = new Node[DEFAULT_CAPACITY];

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
    public boolean containsKey(Object key) {
        int hash = key.hashCode() % DEFAULT_CAPACITY;
        if (table[hash] != null) {
            return table[hash].find(key) != null;
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (table[i] != null) {
                if (table[i].containsValue(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        int hash = key.hashCode() % DEFAULT_CAPACITY;
        if (table[hash] != null) {
            if (table[hash].find(key) != null) {
                return (Object) table[hash].find(key).getValue();
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if (containsKey(key)) {
            int hash = key.hashCode() % DEFAULT_CAPACITY;
            Object prevKey = get(key);
            table[hash].find(key).setValue(value);
            return prevKey;
        }

        Node<K, V> element = new Node<>((K) key, (V) value);
        int hash = element.getHash();
        if (table[hash] == null) {
            table[hash] = element;
        } else {
            table[hash].setLast(element);
        }

        size++;
        return null;
    }

    public Object put(Node element) {
        return put(element.getKey(), element.getValue());
    }


    @Override
    public Object remove(Object key) {
        int hash = key.hashCode() % DEFAULT_CAPACITY;
        Node<K, V> removingElement = null;
        Node<K, V> firstElement = table[hash];

        removingElement = firstElement.find(key);
        if (removingElement != null) {

            if (firstElement.findPrev(key) != null) {
                firstElement.findPrev(key).setNext(removingElement.getNext());
            } else {
                table[hash] = removingElement.getNext();
                System.out.println(777);
            }
            size--;
        }
        return removingElement;
    }

    @Override
    public void putAll(Map m) {
        Set<K> set = m.keySet();
        for (K key : set) {
            put(key, m.get(key));
            size++;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            table[i] = null;
        }
        size=0;
    }

    @Override
    public Set keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            if (table[i] != null) {
                set.addAll(table[i].keySet());
            }
        }
        return set;
    }

    @Override
    public Collection values() {
        Collection<V> collection = new ArrayList<>();
        Set<K> set = keySet();
        for (K key : set) {
            collection.add((V) get(key));
        }
        return collection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        Set<K> keySet = keySet();
        Entry<K, V> element;
        for (K key : keySet) {
            element = (Entry<K, V>) new AbstractMap.SimpleEntry<>(key, get(key));
            set.add((Entry<K, V>) element);
        }
        return set;
    }
}
