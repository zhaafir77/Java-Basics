import java.io.IOException;

public class shutdown {
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "shutdown -s -t 0");

        try {
            processBuilder.start();
            System.out.println("Shutdown command executed.");
        } catch (IOException e) {
            System.err.println("Failed to execute shutdown command: " + e.getMessage());
        }
    }
}