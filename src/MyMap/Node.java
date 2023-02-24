package MyMap;

import java.util.HashSet;
import java.util.Set;

public class Node<K, V> {
    private final int hash;
    private final K key;
    private V value;
    private Node<K, V> next;
    private static final int DEFAULT_CAPACITY = 16;


    public Node(K key, V value) {
        hash = key.hashCode() % DEFAULT_CAPACITY;
        this.key = key;
        this.value = value;
    }

    public int getHash() {
        return hash;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }

    public void setLast(Node element) {
        if (next != null) {
            if (key != next.getKey()) {
                next.setLast(element);
            }
        } else {
            next = element;
        }
    }

    public void setNext(Node element) {
        next = element;
    }

    public Node find(Object key) {
        if (this.key == key) {
            return this;
        }
        if (next != null) {
            return next.find(key);
        }
        return null;
    }

    public Node findPrev(Object key) {
        if (next != null) {
            if (next.getKey() == key) {
                return this;
            }
            if (next.getNext() != null) {
                return next.findPrev(key);
            }
        }
        return null;
    }


    public boolean containsValue(Object value) {
        if (this.value == value) {
            return true;
        }
        if (next != null) {
            return next.containsValue(value);
        }
        return false;
    }

    public Set keySet() {
        Set<K> set = new HashSet<>();
        set.add(key);
        if (next != null) {
            set.addAll(next.keySet());
        }
        return set;
    }

    public void setValue(Object value) {
        this.value = (V) value;
    }
}
