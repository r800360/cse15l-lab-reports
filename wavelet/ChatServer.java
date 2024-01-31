import java.io.IOException;
import java.net.URI;

class ChatHandler implements URLHandler {
    

    String chatLog = new String();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return chatLog;
        } else if (url.getPath().contains("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if ( (parameters[0].equals("s")) && (parameters[2].equals("user")) ) {
                chatLog = chatLog + parameters[3].toString() + ": " + parameters[1].toString() + "\n";
                return chatLog;
            }
        } else {
            return "404 Not Found!";
        }
        return "404 Not Found!";
    }
}

class ChatServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new ChatHandler());
    }
}
