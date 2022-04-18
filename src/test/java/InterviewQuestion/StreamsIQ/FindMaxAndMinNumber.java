package InterviewQuestion.StreamsIQ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
public class FindMaxAndMinNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 23, 24, 222, 267, 23, 34, 45, 656, 77,0,-43);
        int max=list.stream().max(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Maximum number is : "+max);

        int min=list.stream().min(Comparator.comparing(Integer::valueOf)).get();
        System.out.println("Minimum number is : "+min);
    }
}
