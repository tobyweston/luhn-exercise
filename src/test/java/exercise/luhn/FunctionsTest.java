package exercise.luhn;

import org.junit.Test;

import static java.util.Arrays.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FunctionsTest {

    @Test
    public void seperatesANumber() {
        assertThat(Functions.separate(1L), is(asList(1)));
        assertThat(Functions.separate(21L), is(asList(2, 1)));
        assertThat(Functions.separate(321L), is(asList(3, 2, 1)));
        assertThat(Functions.separate(4321L), is(asList(4, 3, 2, 1)));
    }

}