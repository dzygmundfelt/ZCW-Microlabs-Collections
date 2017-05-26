package zygmundfelt.dan.bitsetmicrolab;


import java.util.Iterator;

public class Fiboniterator<E> implements Iterator<E> {

    private int prior;
    private int twoPrior;
    private int index;

    Fiboniterator() {
        prior = 1;
        twoPrior = 1;
        index = 1;
    }

    int getIndex() {
        return index;
    }

    public boolean hasNext() {
        return true;
    }

    public E next() {
        int temp = twoPrior;
        twoPrior = prior;
        prior += temp;
        index++;
        return (E) new Integer(prior);
    }
}
