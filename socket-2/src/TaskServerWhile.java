import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TaskServerWhile {
    void start(int port){
        try{
            System.out.println("Server Started");
            ServerSocket serverSocket = new ServerSocket(port);
            Socket soc = serverSocket.accept();

            System.out.println("Connected");
            ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
            int i = Integer.MAX_VALUE;
            while (i > 0) {
                System.out.println("Receiving task " + i);
                TaskObject task = (TaskObject) ois.readObject();

                task.exec();

                oos.writeObject(task);
                oos.flush();
                System.out.println("Sent back the result");

                i--;
            }
        }catch (SocketException e){
            System.out.println("SocketException: " + e);
        }catch (IOException e){
            System.out.println("IOException: " + e);
        }catch (Exception e){
            System.out.println("Exception: " + e);
        }
    }
    public static void main(String[] args) {
        TaskServerOnce server = new TaskServerOnce();
        server.start(8080);
    }
}
