package exercise.luhn;

import java.util.List;
import java.util.stream.Collectors;

public class Functions {

    public static List<Integer> separate(Long number) {
        return number.toString().chars()
                .map(c -> Integer.parseInt(String.valueOf((char) c))).boxed()
                .collect(Collectors.toList());
    }
}
