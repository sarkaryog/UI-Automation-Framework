package InterviewQuestion.StreamsIQ;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
public class GetIgnoreFirt5NumberAnd {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 23, 24, 222, 267, 23, 34, 45, 656, 77, 0, -43);

        List<Integer> first5Number = list.stream().limit(5).collect(Collectors.toList());
        System.out.println("First 5 numbers are: " + first5Number);

        // Sum of first 5 number
        int sum = list.stream().limit(5).reduce((a, b) -> a + b).get();
        System.out.println("Sum of first five numbers are: " + sum);

        // Skip first five number
        List<Integer> first5NumberSkip = list.stream().skip(5).collect(Collectors.toList());
        System.out.println("First 5 numbers are skipped: " + first5NumberSkip);

    }
}
