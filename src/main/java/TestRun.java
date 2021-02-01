import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestRun {

    public static void start(Class testClass)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        runTest(testClass);
    }

    public static void start(String nameTestClass)
            throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        runTest(Class.forName(nameTestClass));
    }

    public static void runTest(Class testClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Method[] allMethods = testClass.getDeclaredMethods();
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        List<MethodClass> arrayList = new ArrayList<>();

        for (Method m : allMethods) {
            if (m.getAnnotation(BeforeSuite.class) != null) {
                if (beforeSuiteMethod != null) {
                    throw new RuntimeException("Two or more BeforeSuite methods");
                } else {
                    beforeSuiteMethod = m;
                    continue;
                }
            }
            if (m.getAnnotation(AfterSuite.class) != null) {
                if (afterSuiteMethod != null) {
                    throw new RuntimeException("Two or more AfterSuite methods");
                } else {
                    afterSuiteMethod = m;
                    continue;
                }
            }
            arrayList.add(new MethodClass(m, m.getAnnotation(Test.class).priority()));

        }
        if (beforeSuiteMethod == null || afterSuiteMethod == null)
            throw new RuntimeException("No BeforeSuite methods and AfterSuite methods");

        arrayList.sort(new SortMethod());

        Object instance = testClass.getConstructor().newInstance();
        beforeSuiteMethod.invoke(instance);
        for (MethodClass methodClass : arrayList) {
            methodClass.m.invoke(instance);
        }
        afterSuiteMethod.invoke(instance);
    }
}