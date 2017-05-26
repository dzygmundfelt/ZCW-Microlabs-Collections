package zygmundfelt.dan.bitsetmicrolab;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MyStack<E> extends Stack<E> {

    private List<E> list;

    MyStack() {
        list = new ArrayList<>();
    }

    public E push(E e) {
        list.add(e);
        return e;
    }

    public E pop() {
        if(list.size() == 0) {
            return null;
        }
        return list.remove(list.size() - 1);
    }

    public E peek() {
        if(list.size() == 0) {
            return null;
        }
        return list.get(size() - 1);
    }

}
