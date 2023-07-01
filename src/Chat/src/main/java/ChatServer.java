import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ChatServer {
    private static final int PORT = 5000;
    private static final int MAX_CLIENTS = 100;
    private static final ThreadPoolExecutor EXECUTOR = (ThreadPoolExecutor) Executors.newFixedThreadPool(MAX_CLIENTS);
    private static final List<ClientHandler> CLIENTS = new ArrayList<>(); // keep track of connected clients
    private static final Map<String, ClientHandler> USERNAME_TO_CLIENT = new HashMap<>(); // map usernames to clients
    private static final Gson GSON = new Gson();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chat server started on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                CLIENTS.add(clientHandler);
                EXECUTOR.execute(clientHandler);
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;
        private final BufferedReader in;
        private final PrintWriter out;
        private String username;

        public ClientHandler(Socket clientSocket) throws IOException {
            this.clientSocket = clientSocket;
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new PrintWriter(clientSocket.getOutputStream(), true);
        }

        @Override
        public void run() {
            try {
                out.println("Enter your username:");
                username = in.readLine();
                USERNAME_TO_CLIENT.put(username, this);
                broadcastMessage(username + " joined the chat");
                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    JsonObject json = GSON.fromJson(input, JsonObject.class);
                    String message = json.get("message").getAsString();
                    String recipient = json.get("recipient").getAsString();
                    String status = "sent";
                    if (json.has("status")) {
                        status = json.get("status").getAsString();
                    }
                    String timestamp = LocalDateTime.now().toString();
                    if (recipient.equals("all")) {
                        broadcastMessage(username, message, timestamp, status);
                    } else {
                        ClientHandler recipientClient = USERNAME_TO_CLIENT.get(recipient);
                        if (recipientClient != null) {
                            recipientClient.sendMessage(username, message, timestamp, status);
                            sendMessage(username, message, timestamp, status);
                        } else {
                            out.println("Recipient not found");
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e);
            } finally {
                if (username != null) {
                    USERNAME_TO_CLIENT.remove(username);
                }
                CLIENTS.remove(this);
                broadcastMessage(username + " left the chat");
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e);
                }
            }
        }

        public void sendMessage(String sender, String message, String timestamp, String status) {
            JsonObject json = new JsonObject();
            json.addProperty("sender", sender);
            json.addProperty("message", message);
            json.addProperty("timestamp", timestamp);
            json.addProperty("status", status);
            out.println(json);
        }
    }

    private static void broadcastMessage(String sender, String message, String timestamp, String status) {
        JsonObject json = new JsonObject();
        json.addProperty("sender", sender);
        json.addProperty("message", message);
        json.addProperty("timestamp", timestamp);
        json.addProperty("status", status);
        String jsonStr = GSON.toJson(json);
        for (ClientHandler client : CLIENTS) {
            client.out.println(jsonStr);
        }
    }

    private static void broadcastMessage(String message) {
        for (ClientHandler client : CLIENTS) {
            client.out.println(message);
        }
    }
}