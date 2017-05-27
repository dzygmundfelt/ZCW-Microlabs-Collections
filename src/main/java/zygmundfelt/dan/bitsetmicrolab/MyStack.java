package zygmundfelt.dan.bitsetmicrolab;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyStack<E> extends Stack<E> {

    private List<E> list;
    private int size;

    MyStack() {
        list = new ArrayList<>();
        size = 0;
    }

    public E push(E e) {
        list.add(e);
        size++;
        return e;
    }

    public E pop() {
        if(list.size() == 0) {
            return null;
        }
        return list.remove(size-- - 1);
    }

    public E peek() {
        if(list.size() == 0) {
            return null;
        }
        return list.get(size - 1);
    }

}
