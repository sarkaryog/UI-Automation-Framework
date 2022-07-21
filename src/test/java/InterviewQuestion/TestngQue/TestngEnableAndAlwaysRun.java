package InterviewQuestion.TestngQue;

import org.testng.annotations.Test;

/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
public class TestngEnableAndAlwaysRun {

    // We can not run class if it enabled is false and always run is true

    @Test(enabled = false,alwaysRun = true)
    public void test(){
        System.out.println("hi");
    }

}
