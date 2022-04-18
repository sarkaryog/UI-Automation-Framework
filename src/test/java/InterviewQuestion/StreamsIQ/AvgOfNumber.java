package InterviewQuestion.StreamsIQ;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
public class AvgOfNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,-2);
        double avg = list.stream().mapToInt(e->e).average().getAsDouble();
        System.out.println("Average : "+avg);

    }
}
