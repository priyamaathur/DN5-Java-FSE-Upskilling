import java.io.*;
import java.net.*;

public class Exercise35_TCPClientServer {

    static void startServer() throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting...");
        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(s.getInputStream()));
        System.out.println("Client says: " + in.readLine());
        s.close();
        ss.close();
    }

    static void startClient() throws IOException {
        Socket s = new Socket("localhost", 5000);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println("Hello from Client!");
        s.close();
    }

    public static void main(String[] args) throws Exception {
        Thread server = new Thread(() -> {
            try { startServer(); }
            catch (IOException e) { e.printStackTrace(); }
        });
        server.start();
        Thread.sleep(500);
        startClient();
    }
}