import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleStack<T extends Comparable<? super T>> {

    private static final int SIZE = 4;
    private int N = 0;

    private T[] items;


    @SuppressWarnings("unchecked")
    SimpleStack() {
        items = (T[]) new Comparable[SIZE];
    }


    @SuppressWarnings("unchecked")
    private void resize(int capacity) {

        T[] ret = (T[]) new Comparable[capacity];

        System.arraycopy(items, 0, ret, 0, items.length);

        items = ret;

    }

    void push(T item) {
        if (N == items.length) resize(2 * items.length);

        items[N++] = item;
    }

    T pop() {
        T ret = items[N - 1];
        items[N - 1] = null;

        N--;

        if (N > 0 && N == items.length / 4) resize(items.length / 2);

        return ret;
    }

    int size() {
        return N;
    }

    T peek() {
        return items[N - 1];
    }
}

class MinStack<T extends Comparable<? super T>> extends SimpleStack<T> {

    private T currentMin;

    T min() {
        return currentMin;
    }


    void push(T element) {
        if (currentMin == null || size() == 0 || element.compareTo(currentMin) <= 0) {
            super.push(currentMin);
            super.push(element);
            currentMin = element;
        } else {
            super.push(element);
        }
    }

    T pop() {
        T ret = super.pop();
        if (ret.compareTo(currentMin) == 0) {
            currentMin = super.pop();
        }

        return ret;
    }
}


public class MinMaxStackTest {
    private int[] randomValues;
    private MinStack<Integer> stack;

    @Before
    public void before() {
        randomValues = IntStream
                .generate(() -> ThreadLocalRandom.current().nextInt(10, 10000))
                .limit(1500).toArray();

        stack = new MinStack<>();
        IntStream.of(randomValues).forEach(stack::push);
    }

    @Test
    public void min_Test() {
        Integer expected = IntStream.of(randomValues).min().getAsInt();
        Integer actual = stack.min();

        System.out.println(String.format("Expected: %s, actual: %s", expected, actual));

        assertThat(expected).isEqualTo(actual);
    }
}
