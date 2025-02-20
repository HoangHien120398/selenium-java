import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTest1 {
    @BeforeSuite
    void beforeSuit(){
        System.out.println("Before suit");
    }

    @BeforeTest
    void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeClass
    void beforeClass(){
        System.out.println("Before class");
    }

    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before method");
    }


    @Test(groups = {"smoke"})
    void tc01(){
        System.out.println("tc 01");
    }

    @Test
    void tc02(){
        System.out.println("tc 02");
    }

     @Test
    void tc03(){
        System.out.println("tc 03");
    }

     @Test
    void tc04(){
        System.out.println("tc 04");
    }

     @Test
    void tc05(){
        System.out.println("tc 05");
    }

    @AfterMethod
    void afterMethod(){
        System.out.println("After method");
    }
    @AfterClass
    void afterClass(){
        System.out.println("After class");
    }
    @AfterTest
    void afterTest(){
        System.out.println("After test");
    }
    @AfterSuite
    void afterSuite(){
        System.out.println("After suite");
    }

    
}
