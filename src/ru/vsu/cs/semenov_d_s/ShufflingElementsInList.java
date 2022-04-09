package ru.vsu.cs.semenov_d_s;

import java.util.HashSet;
import java.util.Random;

public class ShufflingElementsInList<T> {

    public SimpleLinkedList<T> shuffleElementsInList(SimpleLinkedList<T> list) throws SimpleLinkedList.SimpleLinkedListException {
        HashSet<Integer> indexesOfListElements = putIndexesOfListElementsIntoHashSet(list);
        SimpleLinkedList<T> newList = new SimpleLinkedList<>();
        Random rnd = new Random();

        while (!indexesOfListElements.isEmpty()) {
            int index = rnd.nextInt(list.size());
            if (indexesOfListElements.contains(index)) {
                newList.add(list.get(index));
                indexesOfListElements.remove(index);
            }
        }
        return newList;
    }

    private HashSet<Integer> putIndexesOfListElementsIntoHashSet(SimpleLinkedList<T> list) {
        HashSet<Integer> indexesOfListElements = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            indexesOfListElements.add(i);
        }
        return indexesOfListElements;
    }
}
