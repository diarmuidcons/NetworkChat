# NetworkChat
The purpose of this program is to develop a network based chat application using java, and java socket API. The program allows the user, or the “client” to communicate with the server. The ServerSide class is responsible for listening for a connection and accepts it. It also returns the host IP address. It then runs a runnable thread which will implement the functions outlined in the ServerThread class.
One of these functions is initializing the end to end connection of sockets from the server and client side. The BufferedReader is used to buffer the character input stream from the InputStreamReader, increasing efficiency. This input stream is read in using the readLine(), which will read in each line of text which is typed into the console. While this input stream is not empty, and does not contain the stop characters “\q”, BufferedWriter outputs this stream as the message from the client.

The ClientSide class will undertake most of the same functions as the ServerSide class besides setting up the port connection and displaying the host IP address. It also does not contain a thread, as there will only be communication between this client and the server, whereas the server could have multiple clients to communicate with. 

Running the Application.
This program should be run using the windows command prompt window, with the ServerSide class and the Clientside class each having their own window. Using the javac command along with the paths of the classes will start communication between the client and server. It is important that the ServerSide class is run first, as no connection will be made otherwise. Using the command prompt terminal, the user should be able to communicate freely between the client and server using their respective windows.

Resources.
https://www.youtube.com/watch?v=gchR3DpY-8Q
https://stackoverflow.com/questions/60881809/java-net-bindexception-address-already-in-use-jvm-bind-in-spite-of-no-running
https://www.geeksforgeeks.org/multithreaded-servers-in-java/
https://www.geeksforgeeks.org/establishing-the-two-way-communication-between-server-and-client-in-java/
https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html
https://stackoverflow.com/questions/49869553/multi-client-simple-chatnon-gui-server-in-java-using-threads
http://pirate.shu.edu/~wachsmut/Teaching/CSAS2214/Virtual/Lectures/chat-client-server.html
https://stackoverflow.com/questions/37689889/whats-the-best-way-to-set-up-a-two-way-tcp-communication-of-equal-clients-witho
https://cs.lmu.edu/~ray/notes/javanetexamples/
