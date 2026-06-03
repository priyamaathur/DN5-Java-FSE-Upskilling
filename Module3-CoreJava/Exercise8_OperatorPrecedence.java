public class Exercise8_OperatorPrecedence {
    public static void main(String[] args) {
        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1 + " (multiplication first)");

        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2 + " (brackets first)");

        int result3 = 10 + 4 / 2 - 1;
        System.out.println("10 + 4 / 2 - 1 = " + result3);

        boolean result4 = 5 > 3 && 2 < 4;
        System.out.println("5 > 3 && 2 < 4 = " + result4);
    }
}