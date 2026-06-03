public class Exercise38_DecompileClass {
    public static void main(String[] args) {
        System.out.println("Decompile Demo");
        System.out.println("Steps:");
        System.out.println("1. Compile this file: javac DecompileClass.java");
        System.out.println("2. Open .class file in JD-GUI or CFR decompiler");
        System.out.println("3. Decompiler will show original Java source code");
    }

    static String greet(String name) {
        return "Hello, " + name + "!";
    }
}