package exercise.luhn;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.Collections.*;
import static java.util.stream.Collectors.*;

public class Functions {

    public static List<Integer> doubleEverySecondDigitReverseOrder(Long number) {
        List<Integer> values = separate(number);
        reverse(values);
        List<Integer> doubled = IntStream
                .range(0, values.size())
                .map(index -> index % 2 == 0 ? values.get(index) : values.get(index) * 2)
                .boxed()
                .collect(toList());
        reverse(doubled);
        return doubled;
    }

    public static List<Integer> separate(Long number) {
        return number.toString()
                .chars()
                .map(c -> Integer.parseInt(String.valueOf((char) c)))
                .boxed()
                .collect(toList());
    }

}
