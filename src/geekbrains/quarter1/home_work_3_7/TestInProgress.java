package geekbrains.quarter1.home_work_3_7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class TestInProgress {
    int priority;
    Method method;

    public TestInProgress(int priority, Method method) {
        this.priority = priority;
        this.method = method;
    }

    static void startTest(Class className) throws RuntimeException {
        ArrayList<TestInProgress> tests = new ArrayList<>();
        Method before = null;
        Method after = null;

        Method[] methods = className.getDeclaredMethods();
        for (Method m : methods){
            Test a = m.getAnnotation(Test.class);
            if (a != null){
                tests.add(new TestInProgress(a.priority(), m));
            } else if (m.getAnnotation(BeforeSuite.class) != null){
                if (before == null){
                    before = m;
                } else {
                    throw new RuntimeException("Before уже присутствует в классе");
                }
            } else if (m.getAnnotation(AfterSuite.class) != null) {
                if (after == null) {
                    after = m;
                } else {
                    throw new RuntimeException("After уже присутствует в классе");
                }
            }
            if (before != null) tests.add(new TestInProgress(0, before));
            if (after != null) tests.add(new TestInProgress(11, after));
            tests.sort(Comparator.comparing(o -> o.priority));

            for (TestInProgress t : tests){
                try {
                    Object o = className.newInstance();
                    Object result = t.method.invoke(o);
                    System.out.println(t.method.getName() + " = " + result + " приоритет " + t.priority);
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
