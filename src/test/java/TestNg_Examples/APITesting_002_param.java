package TestNg_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting_002_param {

    @Parameters("browser")
    @Test(invocationCount = 5)
    public void test_SanityRun(String value){
        System.out.println("Sanity");
        System.out.println("QA");

        if (value.equalsIgnoreCase("chrome")){
            System.out.println("Start the chrome browser");
        } else if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start firefox browser");

        }

    }

}
