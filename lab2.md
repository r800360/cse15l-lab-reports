## Lab Report 2

# Part 1

The following is the code for my Chat Server written in Java which relies on `Server.java` containing the `URLHandler` interface:

```
import java.io.IOException;
import java.net.URI;

class ChatHandler implements URLHandler {
    

    String chatLog = new String();

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return chatLog;
        } else if (url.getPath().contains("/add-message")) {
            String[] parameters = url.getQuery().split("=");
            if ( (parameters[0].equals("s")) && (parameters[1].contains("user")) ) {
                chatLog = chatLog + parameters[2].toString() + ": " + parameters[1].toString().substring(0, parameters[1].indexOf("&")) + "\n";
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


```

For simplicity, the test cases for  `/add-message` path for the code will be the same as the provided examples, which are as follows:

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab2/ChatServerA.png)

When I enter the above URL into my web browser, the `handleRequest(URI url)` method in the `ChatHandler` class is called. This method contains a series of other methods that are called which include `URI.getPath(URI url)`, `URI.getQuery(URI url)`, `String.split(String s)`, `String.equals(String s)`, `String.contains(String s)`, `String.toString()`, and `String.indexOf(String s)`. For relevance, we will discuss the first two of the aforementioned methods. The `URI.getPath(URI url)` is used to extract the path of the URL that I entered, given an object of the Java URI class, which somehow contains the information of the entire URL `http://localhost:8850/add-message?s=Hello&user=jpolitz`. This is done in order to evaluate whether the root path, a path containing `add-message`, or a different path is being called so that appropriate instructions can be executed in each case. Similarly, the `URI.getQuery(URI url)` is used to extract the query of the URL that I entered, given an object of the Java URI class, which somehow contains the information of the entire URL `http://localhost:8850/add-message?s=Hello&user=jpolitz`. This is done to extract the part of the URL after the `?` (if it is provided) whose parts get converted into a String array so that we can utilize the String parts to identify the user and the provided message directly. From this specific request, the url variable which is of type `URI` takes on the value `/add-message?s=Hello&user=jpolitz`. After execution of the `handleRequest(URI url)` method, the value of the `chatLog` field which is a `String` becomes `jpolitz: Hello` which is displyed to the screen.


![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab2/ChatServerB.png)

When I enter the above URL into my web browser, the `handleRequest(URI url)` method in the `ChatHandler` class is called. This method contains a series of other methods that are called which include `URI.getPath(URI url)`, `URI.getQuery(URI url)`, `String.split(String s)`, `String.equals(String s)`, `String.contains(String s)`, `String.toString()`, and `String.indexOf(String s)`. For relevance, we will discuss the first two of the aforementioned methods. The `URI.getPath(URI url)` is used to extract the path of the URL that I entered, given an object of the Java URI class, which somehow contains the information of the entire URL `http://localhost:8850/add-message?s=How%20are%20you&user=yash`. This is done in order to evaluate whether the root path, a path containing `add-message`, or a different path is being called so that appropriate instructions can be executed in each case. Similarly, the `URI.getQuery(URI url)` is used to extract the query of the URL that I entered, given an object of the Java URI class, which somehow contains the information of the entire URL `http://localhost:8850/add-message?s=How%20are%20you&user=yash`. This is done to extract the part of the URL after the `?` (if it is provided) whose parts get converted into a String array so that we can utilize the String parts to identify the user and the provided message directly. From this specific request, the url variable which is of type `URI` takes on the value `/add-message?s=How%20are%20you&user=yash`. After execution of the `handleRequest(URI url)` method, the value of the `chatLog` field which is a `String` becomes `jpolitz: Hello\nyash: How are you` which is displyed to the screen.

# Part 2

Here, I have included a screenshot depicting the application of the `ls` command to list the absolute directory to the private key on my personal computer for the ssh connection to my `ieng6` machine.
![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab2/PrivateSSHKey.png)

Here, I have included a screenshot depicting the application of the `ls` command to list the absolute directory to the corresponding public key on the ieng6 machine.

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab2/PublicSSHKey.png)

Here, I have included a screenshot depicting the process of performing an SSH connection to my `ieng6` machine without a password due to the adaption of the aforementioned public and private keys.

![Image](https://r800360.github.io/cse15l-lab-reports/Images/Lab2/SSH_Without_Password.png)

# Part 3

Something that I learned in lab in Week 2 was how to create my own web server in Java that incorporates paths and queries. This skill can help me in developing larger projects, some of which I have seen are a flight application that tracks tickets, passengers, flights, and airlines as well as a task list application that keeps track of tasks and users that are assigned to a task. Something that I learned in lab in Week 3 was the secure copy command which applies many of the concepts that I learned in MATH 187A: Introduction to Cryptography to be able to securely transfer information between a local and a remote sytem.
