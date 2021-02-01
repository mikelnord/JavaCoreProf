
public class TestExample {

    @BeforeSuite
    public void firstTest() {
        System.out.println("First method");
    }

    @Test(priority = 1)
    public void TestOne() {
        System.out.println("One test completed...");
    }

    @Test(priority = 2)
    public void TestTwo() {
        System.out.println("Two test completed...");
    }

    @Test(priority = 3)
    public void TestThree() {
        System.out.println("Three test completed...");
    }

    @Test(priority = 4)
    public void TestFour() {
        System.out.println("Four test completed...");
    }

    @Test(priority = 5)
    public void TestFive() {
        System.out.println("Five test completed...");
    }

    @Test(priority = 2)
    public void TestTwoAlso() {
        System.out.println("Two also test completed...");
    }

    @AfterSuite
    public void lastTest() {
        System.out.println("Last method");
    }
}