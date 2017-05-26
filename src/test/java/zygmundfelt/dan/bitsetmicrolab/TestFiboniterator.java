package zygmundfelt.dan.bitsetmicrolab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestFiboniterator {

    Fiboniterator<Integer> fibonacci;

    @Before
    public void initialize() {
        fibonacci = new Fiboniterator<>();
    }

    @Test
    public void indexAtInitialTest() {
        int expected = 1;

        int actual = fibonacci.getIndex();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void indexAfterSeveralNextsTest() {
        int expected = 8;
        for(int i = 0; i < 7; i++) {
            fibonacci.next();
        }

        int actual = fibonacci.getIndex();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fibonacciNumbersOneToTenTest() {
        int[] expected = {1,2,3,5,8,13,21,34,55,89};

        int[] actual = new int[10];
        actual[0] = 1;
        for(int i = 1; i < 10; i++) {
            actual[i] = fibonacci.next();
        }

        for(int i = 0; i < 10; i++) {
            Assert.assertEquals(expected[i], actual[i]);
        }
    }

    @Test
    public void hasNextTest() {
        for(int i = 0; i < 21; i++) {
            fibonacci.hasNext();
        }

        boolean result = fibonacci.hasNext();

        Assert.assertTrue(result);
    }
}
