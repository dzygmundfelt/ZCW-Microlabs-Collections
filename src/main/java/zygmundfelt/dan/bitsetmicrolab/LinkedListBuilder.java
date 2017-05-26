package zygmundfelt.dan.bitsetmicrolab;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LinkedListBuilder<E> implements ListBuilder<E> {

    public List<E> buildList(E[] array) {
        List<E> list = new LinkedList<>();
        for(E element : array) {
            list.add(element);
        }
        return list;
    }

    public List<E> buildList(Collection<E> c) {
        List<E> list = new LinkedList<>();
        list.addAll(c);
        return list;
    }
}
