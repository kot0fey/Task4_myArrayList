package MyHashSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Node<T> {
    private final int hash;
    private final T data;
    private Node<T> next;
    private static final int DEFAULT_CAPACITY = 16;


    public Node(Object data) {
        hash = data.hashCode() % DEFAULT_CAPACITY;
        this.data = (T) data;
    }

    public int getHash() {
        return hash;
    }

    public T getData() {
        return data;
    }

    public boolean contains(Object data) {
        if (this.data == data) {
            return true;
        }
        if (next != null) {
            return next.contains(data);
        }
        return false;
    }

    public void setLast(Object data) {
        if (next != null) {
            next.setLast(data);
        } else {
            next = new Node<T>(data);
        }
    }

    public Node findPrev(Object data) {
        if (next != null) {
            if (next.getData() == data) {
                return this;
            }
            if (next.getNext() != null) {
                return next.findPrev(data);
            }
        }
        return null;
    }


    public Node getNext() {
        return next;
    }


    public void setNext(Object data) {
        next = new Node<T>(data);
    }



   /* public boolean find(Object data) {
        if (this.data == data) {
            return true;
        }
        if (next != null) {
            return next.find(data);
        }
        return false;
    }



/*
    public Set dataSet() {
        Set<T> set = new MyHashSet<>();
        set.add(data);
        if (next != null) {
            set.addAll((Collection<? extends T>) next.data);
        }
        return set;
    }

 */
}

