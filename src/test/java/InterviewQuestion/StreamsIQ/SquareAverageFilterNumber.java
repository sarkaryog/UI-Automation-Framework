package InterviewQuestion.StreamsIQ;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
public class SquareAverageFilterNumber {
    public static void main(String[] args) {
        //Square of each number
        //Filter values which is less than 100
        //Get the average for filtered value
        List<Integer> list = Arrays.asList(2, 3, 10, 15, 20);
        double avgOfSquareFilterValues = list.stream()
                .map(e -> e * e) //Square
                .filter(e -> e > 100) //Filter
                .mapToInt(e -> e).average().getAsDouble(); //Average
        System.out.println("Value: " + avgOfSquareFilterValues);
    }
}
