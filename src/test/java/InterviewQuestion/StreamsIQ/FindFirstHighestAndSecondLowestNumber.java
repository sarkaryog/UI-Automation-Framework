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
public class FindFirstHighestAndSecondLowestNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 23, 24, 222, 267, 23, 34, 45, 656, 77, 0, -43);

        // First highest number
        int firstHighestNumber = list.stream().sorted(Collections.reverseOrder()).distinct().findFirst().get();
        System.out.println("First highest number is: "+firstHighestNumber);

        int secondHighestNumber = list.stream().sorted(Collections.reverseOrder()).distinct().skip(1).findFirst().get();
        System.out.println("Second highest number is: "+secondHighestNumber);

        // First lowest number
        int firstLowestNumber = list.stream().sorted().distinct().findFirst().get();
        System.out.println("First lowest number is: "+firstLowestNumber);

        int secondLowestNumber = list.stream().sorted().distinct().skip(1).findFirst().get();
        System.out.println("Second lowest number is: "+secondLowestNumber);
    }
}
