import java.lang.reflect.InvocationTargetException;

public class MainClass {

    public static void main(String[] args) {

        TestRun testRun = new TestRun();
        try {
            testRun.start(TestExample.class);
        } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}