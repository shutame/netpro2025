import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TaskClientOnce {
    public static void main(String[] args) {
        TaskObject taskObject = new TaskObject();
        taskObject.setExecNumber(20);

        try{
            Socket socket = new Socket("localhost", 8080);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(taskObject);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            taskObject = (TaskObject) ois.readObject();

            oos.close();
            ois.close();
            socket.close();
            System.out.println(taskObject.getResult());
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
