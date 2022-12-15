import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ListServer {

    public static void main(String[] args) throws Exception {

        // Get port
        int port = Integer.parseInt(args[0]);

        // Create a ServerSocket and bind to the port
        ServerSocket server = new ServerSocket(port);
        System.out.printf("Listening on port %d/n", port);
    
                // DataInputStream dis = new DataInputStream(new BufferedInputStream(sc.getInputStream()))
    
                // String line = dis.readUTF();
                // while ( line.equalsIgnoreCase("EOF") && line != null) {
                //     System.out.println("Got: -> " + line);
                // }

        while (true) {
            // Wait for connection
            System.out.println("Waiting for connections...");
            Socket socket = server.accept();

            System.out.println("New connection from " + socket.getLocalPort());

            String payload = IOUtils.read(socket);
            String[] values = payload.split(" ");
            Integer count = Integer.parseInt(values[0]);
            Integer range = Integer.parseInt(values[1]);
            List<Integer> randNums = new LinkedList<>();
            for (int i = 0; i < count; i++) {
                randNums.add(rnd.nextInt(range));
            }

            String response = randNums.stream()
                .map(v -> v.toString())
                .collect(Collectors.joining(":"));

            IOUtils.write(socket, response);

            socket.close();
        }
        
    }



}