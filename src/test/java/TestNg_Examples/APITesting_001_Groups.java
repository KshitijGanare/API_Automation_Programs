package TestNg_Examples;

import org.testng.annotations.Test;

public class APITesting_001_Groups {


     @Test(groups = {"Sanity"},priority = -1)
     public void test_SanityRun(){
         System.out.println("Sanity");
         System.out.println("QA");

     }


     @Test(groups = {"Regression"},priority = -10)
     public void test_RegRun(){
         System.out.println("Regression");
     }


     @Test(groups = {"Smoke"})
     public void test_SmokeRun(){
         System.out.println("Smoke");
     }


}
