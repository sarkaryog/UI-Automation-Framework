package InterviewQuestion.StreamsIQ;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
public class SumOfNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 44, 555, 55, 77, 89, 90);

        //Sum of all numbers
        Optional<Integer> sum = list.stream().reduce((a, b) -> (a + b));
        System.out.println("Sum of numbers: " + sum.get());

        //Subtraction of all numbers
        Optional<Integer> sub = list.stream().reduce((a,b)->(a-b));
        System.out.println("Subtraction of numbers: "+sub.get());
    }
}
