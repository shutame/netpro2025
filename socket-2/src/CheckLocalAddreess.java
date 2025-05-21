import java.net.InetAddress;
public class CheckLocalAddreess {
    public static void main(String[] args){
        try {
            // IP Address
            InetAddress addr
            = InetAddress.getLocalHost();
            // Host name
            System.out.println("Host name is: "
            + addr.getHostName());
            // Host Address
            System.out.println("Ip address is: "
            + addr.getHostAddress());
        }catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
}
