public class Exercise40_VirtualThreads {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Launching 100 virtual threads...");

        for (int i = 1; i <= 100; i++) {
            final int num = i;
            Thread.startVirtualThread(() ->
                System.out.println("Virtual Thread " + num + " running")
            );
        }

        Thread.sleep(2000);
        System.out.println("All virtual threads done!");
    }
}