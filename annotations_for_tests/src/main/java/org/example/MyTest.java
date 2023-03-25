package org.example;

public class MyTest {
    @TestMethod("addition")
    public void testAddition() {
        int result = 2 + 2;
        if (result == 4) {
            System.out.println("Test passed: addition");
        } else {
            System.out.println("Test failed: addition");
        }
    }

    @TestMethod("subtraction")
    public void testSubtraction() {
        int result = 4 - 2;
        if (result == 2) {
            System.out.println("Test passed: subtraction");
        } else {
            System.out.println("Test failed: subtraction");
        }
    }

    public void testMultiplication() {
        int result = 2 * 3;
        if (result == 6) {
            System.out.println("Test passed: multiplication");
        } else {
            System.out.println("Test failed: multiplication");
        }
    }

    public static void main(String[] args) {
        MyTest test = new MyTest();
        for (java.lang.reflect.Method method : MyTest.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(TestMethod.class)) {
                String testName = method.getAnnotation(TestMethod.class).value();
                System.out.println("Running test: " + testName);
                try {
                    method.invoke(test);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}