import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 5000;
    private static final Gson GSON = new Gson();

    private final String username;
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    public ChatClient(String username) throws IOException {
        this.username = username;
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void start() throws IOException {
        System.out.println("Connected to chat server");
        Thread inputThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String input = in.readLine();
                        if (input == null) {
                            return;
                        }
                        //JsonObject json = GSON.fromJson(input, JsonObject.class);
                        JsonObject json = new JsonObject();
                        String sender = json.get("sender").getAsString();
                        String message = json.get("message").getAsString();
                        String timestamp = json.get("timestamp").getAsString();
                        String status = json.get("status").getAsString();
                        if (sender.equals(username)) {
                            continue;
                        }
                        System.out.println(sender + " [" + timestamp + "]: " + message + " (" + status + ")");
                    }
                } catch (IOException e) {
                    System.err.println("Error reading from server: " + e);
                }
            }
        });
        inputThread.start();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String recipient = "";
            System.out.print("Enter recipient username (or 'all' for broadcast): ");
            recipient = scanner.nextLine();
            System.out.print("Enter message: ");
            String message = scanner.nextLine();
            JsonObject json = new JsonObject();
            json.addProperty("recipient", recipient);
            json.addProperty("message", message);
            String jsonStr = GSON.toJson(json);
            out.println(jsonStr);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        ChatClient client = new ChatClient(username);
        client.start();
    }
}