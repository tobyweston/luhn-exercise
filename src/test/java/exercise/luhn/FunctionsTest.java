package exercise.luhn;

import org.junit.Test;

import static exercise.luhn.Functions.doubleEverySecondDigitReverseOrder;
import static java.util.Arrays.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FunctionsTest {

    @Test
    public void doublesTheNumber() {
        assertThat(doubleEverySecondDigitReverseOrder(0L), is(asList(0)));
        assertThat(doubleEverySecondDigitReverseOrder(1L), is(asList(1)));
        assertThat(doubleEverySecondDigitReverseOrder(21L), is(asList(4, 1)));
        assertThat(doubleEverySecondDigitReverseOrder(121L), is(asList(1, 4, 1)));
        assertThat(doubleEverySecondDigitReverseOrder(3121L), is(asList(6, 1, 4, 1)));
        assertThat(doubleEverySecondDigitReverseOrder(1234567890L), is(asList(2, 2, 6, 4, 10, 6, 14, 8, 18, 0)));
    }

    @Test
    public void separateANumber() {
        assertThat(Functions.separate(1L), is(asList(1)));
        assertThat(Functions.separate(21L), is(asList(2, 1)));
        assertThat(Functions.separate(321L), is(asList(3, 2, 1)));
        assertThat(Functions.separate(4321L), is(asList(4, 3, 2, 1)));
    }

}