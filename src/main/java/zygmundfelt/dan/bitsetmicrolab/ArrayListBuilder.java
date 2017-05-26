package zygmundfelt.dan.bitsetmicrolab;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBuilder<E> implements ListBuilder<E> {

    public List<E> build(E[] array) {
        List<E> list = new ArrayList<>();
        for(E element : array) {
            list.add(element);
        }
        return list;
    }

}
