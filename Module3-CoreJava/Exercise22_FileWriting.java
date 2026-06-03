import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise22_FileWriting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text to write: ");
        String text = sc.nextLine();

        try {
            FileWriter fw = new FileWriter("output.txt");
            fw.write(text);
            fw.close();
            System.out.println("Data written to output.txt successfully!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}