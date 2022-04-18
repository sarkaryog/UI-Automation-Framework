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
public class SortNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 23, 24, 222, 267, 23, 34, 45, 656, 77, 0, -43);
        List<Integer> sortedAscOrder= list.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted number in Asc order: "+sortedAscOrder);

        List<Integer> sortedDscOrder= list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted number in Asc order: "+sortedDscOrder);
    }
}
