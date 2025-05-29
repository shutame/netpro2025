import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class UDPServer {
    public static void main(String[] args) {
        int port = 9876; // サーバーのポート番号
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(port);
            byte[] buf;
            while(true){
                System.out.println("Server is running on port: " + socket.getLocalPort());

                buf = new byte[1024];
                DatagramPacket request = new DatagramPacket(buf, buf.length);
                socket.receive(request);

                //packet received
                String message = new String(request.getData(), 0, request.getLength());
                System.out.println("受信: " + message);

                //get client address
                SocketAddress clientAddress = request.getSocketAddress();

                //make response
                String responceStr = message.toUpperCase();
                buf = responceStr.getBytes();

                // send response
                DatagramPacket response = new DatagramPacket(buf, buf.length, clientAddress);
                socket.send(response);
                System.out.println("送信: " + responceStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }
    }
}