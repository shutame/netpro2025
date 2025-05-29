import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        int port = 9876;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter some message");
        DatagramSocket socket = null;
        byte[] buf;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            String message = scanner.nextLine(); // ユーザーからの入力を取得
            buf = message.getBytes();

            // 送信パケットを作成
            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, serverAddress, port);
            socket.send(sendPacket);
            System.out.println("送信: " + message);

            // response from server
            buf = new byte[1024];
            DatagramPacket response = new DatagramPacket(buf, buf.length);
            socket.receive(response);
            String responseStr = new String(response.getData(), 0, response.getLength());
            System.out.println("返答: " + responseStr);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
                scanner.close();
            }
        }
    }
}