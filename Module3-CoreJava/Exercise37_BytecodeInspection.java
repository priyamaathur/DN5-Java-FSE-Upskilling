public class Exercise37_BytecodeInspection {
    public static void main(String[] args) {
        System.out.println("Bytecode Inspection Demo");
        System.out.println("Steps:");
        System.out.println("1. Compile: javac BytecodeInspection.java");
        System.out.println("2. Inspect: javap -c BytecodeInspection");
        System.out.println("3. This shows JVM instructions like: iload, istore, invokevirtual");
    }

    static int add(int a, int b) {
        return a + b;
    }
}