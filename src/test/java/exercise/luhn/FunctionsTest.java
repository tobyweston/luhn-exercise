package exercise.luhn;

import org.junit.Ignore;
import org.junit.Test;

import static exercise.luhn.LuhnsAlgorithmCreditCardValidator.Functions.*;
import static exercise.luhn.LuhnsAlgorithmCreditCardValidator.Functions.doubleEverySecondDigitReverseOrder;
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
        assertThat(separate(1L), is(asList(1)));
        assertThat(separate(21L), is(asList(2, 1)));
        assertThat(separate(321L), is(asList(3, 2, 1)));
        assertThat(separate(4321L), is(asList(4, 3, 2, 1)));
    }

    @Test
    public void sumIndividualDigits() {
        assertThat(sumOfSingleDigits(asList()), is(0));
        assertThat(sumOfSingleDigits(asList(0)), is(0));
        assertThat(sumOfSingleDigits(asList(1, 0)), is(1));
        assertThat(sumOfSingleDigits(asList(1, 2)), is(3));
        assertThat(sumOfSingleDigits(asList(1, 2, 4)), is(7));
        assertThat(sumOfSingleDigits(asList(10, 2, 4)), is(7));
        assertThat(sumOfSingleDigits(asList(10, 12, 24)), is(10));
    }

    @Test
    public void isANumberDivisibleByTenExactly() {
        assertThat(isDivisibleByTenExactly(0), is(true));
        assertThat(isDivisibleByTenExactly(1), is(false));
        assertThat(isDivisibleByTenExactly(2), is(false));
        assertThat(isDivisibleByTenExactly(3), is(false));
        assertThat(isDivisibleByTenExactly(5), is(false));
        assertThat(isDivisibleByTenExactly(10), is(true));
        assertThat(isDivisibleByTenExactly(11), is(false));
        assertThat(isDivisibleByTenExactly(20), is(true));
    }

    @Test
    public void isANegativeNumberDivisibleByTenExactly() {
        assertThat(isDivisibleByTenExactly(-10), is(false));
        assertThat(isDivisibleByTenExactly(-1), is(false));
    }
}