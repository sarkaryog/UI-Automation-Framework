package InterviewQuestion.StreamsIQ;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
public class PrintOddAndEvenNumbers {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,34,33,45,66,56,21,89,88,0);

        // Even Numbers
        List<Integer> evenNumber= list.stream().filter(e->e%2==0).collect(Collectors.toList());
        System.out.println("Even Numbers from list: "+evenNumber);

        // Odd numbers
        List<Integer> oddNumber= list.stream().filter(e->e%2!=0).collect(Collectors.toList());
        System.out.println("Odd Numbers from list: "+oddNumber);

    }
}
