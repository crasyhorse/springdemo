package spring.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl {

    @Autowired
    @Qualifier("bubble")
    private SortAlgorithm sortAlgorithm;

    public final int binarySearch(
            final int[] numbers,
            final int numberToSearchFor) {
        int[] sortedNumbers = sortAlgorithm.sort(numbers);

        return 3;
    }
}
