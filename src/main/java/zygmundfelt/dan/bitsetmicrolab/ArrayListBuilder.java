package zygmundfelt.dan.bitsetmicrolab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ArrayListBuilder<E> implements ListBuilder<E> {

    public List<E> buildList(E[] array) {
        List<E> list = new ArrayList<>();
        for(E element : array) {
            list.add(element);
        }
        return list;
    }

    public List<E> buildList(Collection<E> c) {
        List<E> list = new ArrayList<>();
        list.addAll(c);
        return list;
    }

}
