import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ListClient {

    public static void main(String[] args) throws Exception {
        
        // Get list size
        int nums = Integer.parseInt(args[0]);

        // Get range
        int range = Integer.parseInt(args[1]);

        // Get the host
        String host = args[2];

        // Get the port
        int port = Integer.parseInt(args[3]);

        // Create a ClientSocket and bind to the port
        Socket socket = new Socket(host, port);
        System.out.printf("Connected to %s: %d\n", host, port);
        
        // Output Stream
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        socket.getOutputStream();

        // Input Stream
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        socket.getInputStream();

        dos.writeUTF("");

        List<Integer> numList = new ArrayList<Integer>();

        Random rand = new SecureRandom();
        for (int i = 0; i < nums; i++) {
            int num = rand.nextInt(range);
            numList.add(num);
        }
        
        
        IOUtils.write(socket, "%d %d". formatted(nums, range));

        String response = IOUtils.read(socket);
        socket.close();
    }

    
}
