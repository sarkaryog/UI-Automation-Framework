package InterviewQuestion.TestngQue;

import org.testng.annotations.Test;

/**
 * Author: Yogesh Sondhiya
 * GitHub: https://github.com/sarkaryog/UI-Automation-Framework
 * LinkedIn: https://www.linkedin.com/in/yogesh-sondhiya-79a75295/
 */
public class InvocationTimeOut {

    // It will through ThreadTimeOutException if test didn't finish within time-out
    @Test(invocationTimeOut = 5, invocationCount = 100000)
    public void test(){
        System.out.println("Hello Word");
    }
}
