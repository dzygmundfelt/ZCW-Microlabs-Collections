package zygmundfelt.dan.bitsetmicrolab;

import org.junit.*;

import java.util.LinkedList;
import java.util.List;

public class TestArrayListBuilder {

    private Integer[] integers;
    private Number[] numbers;
    private ArrayListBuilder<Integer> intBuilder;
    private ArrayListBuilder<Number> numBuilder;
    private LinkedList<String> strings;
    private ArrayListBuilder<String> strBuilder;

    @Before
    public void initialize() {
        integers = new Integer[3];
        integers[0] = -15;
        integers[1] = 787;
        integers[2] = -232;

        numbers = new Number[0];

        intBuilder = new ArrayListBuilder<>();
        numBuilder = new ArrayListBuilder<>();

        strings = new LinkedList<>();
        strings.add("Hey");
        strings.add("there");
        strings.add("zig");
        strings.add("!");

        strBuilder = new ArrayListBuilder<>();
    }

    @Test
    public void buildEmptyTest() {
        List<Number> actual = numBuilder.buildList(numbers);

        int result = actual.size();

        Assert.assertEquals(result, 0);
    }

    @Test
    public void buildNonemptyTest() {
        int[] expected = {-15, 787, -232};

        List<Integer> actual = intBuilder.buildList(integers);

        for(int i = 0; i < 3; i++) {
            Assert.assertEquals(expected[i], actual.get(i).intValue());
        }
    }

    @Test
    public void buildCollectionTest() {
        String[] expected = {"Hey","there","zig","!"};

        List<String> actual = strBuilder.buildList(strings);

        for(int i = 0; i < 4; i++) {
            Assert.assertEquals(expected[i], actual.get(i));
        }
    }

}
