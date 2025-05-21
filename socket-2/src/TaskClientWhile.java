import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TaskClientWhile {
    public static void main(String[] args) {
        TaskObject taskObject = new TaskObject();
        taskObject.setExecNumber(900000);

        try{
            System.out.println("Client Started");
            Socket socket = new Socket("localhost", 8080);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            System.out.println("Connected");
            int i = Integer.MAX_VALUE;
            while (i > 0) {
                System.out.println("Sending task " + i);
                oos.writeObject(taskObject);
                oos.flush();

                taskObject = (TaskObject) ois.readObject();

                System.out.println(taskObject.getResult());
                i--;
            }
        }catch (Exception e){
            System.out.println("Error: " + e);
        }
    }
}
