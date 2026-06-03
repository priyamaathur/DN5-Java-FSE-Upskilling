import java.lang.reflect.*;

public class Exercise39_ReflectionAPI {

    static class Sample {
        public void sayHello() {
            System.out.println("Hello from Reflection!");
        }
        public int add(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("ReflectionAPI$Sample");

        System.out.println("Class: " + cls.getName());
        System.out.println("Methods:");

        for (Method m : cls.getDeclaredMethods()) {
            System.out.println(" - " + m.getName());
        }

        Object obj = cls.getDeclaredConstructor().newInstance();
        Method method = cls.getMethod("sayHello");
        method.invoke(obj);
    }
}