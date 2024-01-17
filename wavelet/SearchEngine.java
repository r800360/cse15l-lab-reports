import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

//protected ArrayList<String> stringList = new ArrayList<String>();

class SearchHandler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.

    /*Examples of paths/queries:


    /add?s=anewstringtoadd

    /add?s=pineapple

    /add?s=apple

    /search?s=app
    (would return pineapple and apple)*/

    ArrayList<String> stringList = new ArrayList<String>();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            String returnString = new String();
            for (int i = 0; i < stringList.size(); i++) {
                returnString += stringList.get(i);
                returnString += "\n";
            }
            return String.format(returnString);
        } else if (url.getPath().contains("/search")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                String returnString = new String();
                for (int i = 0; i < stringList.size(); i++) {
                    if (stringList.get(i).contains(parameters[1])) {
                        returnString += stringList.get(i);
                        returnString += "\n";
                    }
                }
                if (returnString.length() == 0) {
                    return String.format("No search results.");
                }
                return String.format(returnString);
            }
        } else if (url.getPath().contains("/add")) {
            String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                stringList.add(parameters[1].toString());
                return String.format("Search %s added to the search list!");
            }
        } else {
            return "404 Not Found!";
        }
        return "404 Not Found!";
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new SearchHandler());
    }
}
