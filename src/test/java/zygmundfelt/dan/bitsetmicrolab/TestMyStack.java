package zygmundfelt.dan.bitsetmicrolab;

import org.junit.*;

public class TestMyStack {

    @Test
    public void popFromEmptyTest() {
        MyStack<String> stack = new MyStack<>();

        String result = stack.pop();

        Assert.assertEquals(null, result);
    }

    @Test
    public void popFromNonemptyTest() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(14);
        stack.push(-2);
        Integer expected = -2;

        Integer actual = stack.pop();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void peekFromEmptyTest() {
        MyStack<Number> stack = new MyStack<>();

        Number result = stack.peek();

        Assert.assertEquals(null, result);
    }

    @Test
    public void peekFromNonemptyTest() {
        MyStack<String> stack = new MyStack<>();
        stack.push("dan");
        stack.push("and");
        stack.push("nad");
        String expected = "nad";

        String actual = stack.peek();

        Assert.assertEquals(expected, actual);
    }

}
