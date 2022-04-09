package ru.vsu.cs.semenov_d_s;

public class Main {

    public static void main(String[] args) throws SimpleLinkedList.SimpleLinkedListException {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(3);
        list.add(5);
        list.add(0);
        list.add(1);
        list.add(7);
        list.add(6);

        printListBeforeShuffling(list);

        ShufflingElementsInList<Integer> shufflingElementsInList = new ShufflingElementsInList<>();
        SimpleLinkedList<Integer> listResult = shufflingElementsInList.shuffleElementsInList(list);

        printListAfterShuffling(listResult);
    }

    private static void printListBeforeShuffling(SimpleLinkedList<Integer> list) {
        int i = 0;
        for (Integer v : list) {
            System.out.print((i > 0 ? ", " : "") + v);
            i++;
        }
        System.out.println();
    }

    private static void printListAfterShuffling(SimpleLinkedList<Integer> list) {
        int i = 0;
        for (Integer v : list) {
            System.out.print((i > 0 ? ", " : "") + v);
            i++;
        }
    }
}
