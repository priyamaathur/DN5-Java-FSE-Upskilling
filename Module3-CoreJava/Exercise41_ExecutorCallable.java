import java.util.concurrent.*;
import java.util.*;

public class Exercise41_ExecutorCallable {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(() -> { System.out.println("Task 1"); return 1; });
        tasks.add(() -> { System.out.println("Task 2"); return 2; });
        tasks.add(() -> { System.out.println("Task 3"); return 3; });

        List<Future<Integer>> results = executor.invokeAll(tasks);

        for (Future<Integer> f : results) {
            System.out.println("Result: " + f.get());
        }

        executor.shutdown();
    }
}