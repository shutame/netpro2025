import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {
    ServerSocket soc;

    public TCPServer(int port){
        soc = new ServerSocket(port);
    }

    public void start(){
        System.out.println("Server Started on Port: " + soc.getLocalPort());
        try{
            Socket connection = soc.accept();

            var ois = new ObjectInputStream(connection.getInputStream());
            var oos = new ObjectOutputStream(connection.getOutputStream());

        }catch(SocketException e){
            System.out.println("SocketException: " + e);
        }catch(IOException e){
            System.out.println("IOException: " + e);
        }catch(Exception e){
            System.out.println(e);
        }finally{
            soc.close();
        }
    }
    
}
