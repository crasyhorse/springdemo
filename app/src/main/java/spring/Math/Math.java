package spring.Math;

import java.util.Arrays;
import java.util.List;

public class Math {

    public int sum(Integer... numbers) {
        List<Integer> integers = Arrays.asList(numbers);
        Integer sum = integers.stream()
                .reduce(0, Integer::sum);

        return sum;
    }
}
