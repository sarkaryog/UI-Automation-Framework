package InterviewQuestion.StreamsIQ;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
public class PrintNumbersWhichIsStartingWith2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 23, 24, 222, 267, 23, 34, 45, 656, 77);
        List<Integer> numberWith2 = list.stream()
                .map(e -> String.valueOf(e))// Change integer value to String
                .filter(e -> e.startsWith("2")) // Filter value which starts with 2
                .map(Integer::valueOf).collect(Collectors.toList()); // Again convert string to int
        System.out.println("Numbers start with 2 : " + numberWith2);
    }
}
