package ru.vsu.cs.semenov_d_s;

import java.util.Iterator;

public class SimpleLinkedList<T> implements Iterable<T> {

    public static class SimpleLinkedListException extends Exception {
        public SimpleLinkedListException(String message) {
            super(message);
        }
    }

    private class SimpleLinkedListNode {
        public T value;
        public SimpleLinkedListNode next;

        public SimpleLinkedListNode(T value, SimpleLinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public SimpleLinkedListNode(T value) {
            this(value, null);
        }
    }

    private SimpleLinkedListNode head = null;
    private SimpleLinkedListNode tail = null;
    private int size = 0;

    public void add(T value) {
        if (size == 0) {
            head = tail = new SimpleLinkedListNode(value);
        } else {
            tail.next = new SimpleLinkedListNode(value);
            tail = tail.next;
        }
        size++;
    }

    private void checkEmptyError() throws SimpleLinkedListException {
        if (size == 0) {
            throw new SimpleLinkedListException("Empty list");
        }
    }

    private SimpleLinkedListNode getNode(int index) {
        SimpleLinkedListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void removeFirst() throws SimpleLinkedListException {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    public void remove(int index) throws SimpleLinkedListException {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new SimpleLinkedListException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            SimpleLinkedListNode prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }

    public int size() {
        return size;
    }

    public T get(int index) throws SimpleLinkedListException {
        checkEmptyError();
        return getNode(index).value;
    }

    @Override
    public Iterator<T> iterator() {
        class SimpleLinkedListIterator implements Iterator<T> {
            SimpleLinkedListNode curr = head;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public T next() {
                T value = curr.value;
                curr = curr.next;
                return value;
            }
        }

        return new SimpleLinkedListIterator();
    }
}

