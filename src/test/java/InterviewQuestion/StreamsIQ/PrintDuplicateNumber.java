package InterviewQuestion.StreamsIQ;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
public class PrintDuplicateNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,1,23,23,45,46,57,46,34,56,57,45,23,34,89,22,90,44,34,46);

        Set<Integer> uniqueNumber = list.stream()
                .filter(e-> Collections.frequency(list,e)>1)
                .collect(Collectors.toSet());
        System.out.println("Duplicate numbers are: "+uniqueNumber);

        Set<Integer> duplicateNumber = new HashSet<>();
        Set<Integer> uniqueNumber2= list.stream().filter(e->!duplicateNumber.add(e)).collect(Collectors.toSet());
        System.out.println("Duplicate numbers are: "+uniqueNumber2);;
    }
}
