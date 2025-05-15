import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Scanner;

public class GuessingServer {

    private static final int times = 2;

    private static String serverProcess(String content) {
        StringBuilder sb = new StringBuilder();
        sb.append("🎁");
        for (int i = 0; i < times; i++) {
            sb.append(content);
        }
        sb.append("🎁");
        String result = sb.toString();
        return result;
    }

    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());



            int validNum = new Random().nextInt(11);
            System.out.println("今回は" + validNum);
            boolean isValid = false;
            while (!isValid) {
                Payload request = (Payload) ois.readObject();// Integerクラスでキャスト。

                String count = request.getMessage();
                System.out.println(count + "回目");
                String num = request.getContent();
                System.out.println("相手の予想は" + num + "です");

                Payload response = new Payload();
                int intNum = Integer.valueOf(num);
                if(intNum == validNum){
                    isValid = true;
                    response.setMessage("success");
                    response.setContent("正解！！！");;
                }else{
                    response.setMessage("faild");
                    response.setContent("残念はずれ！もう一回！！");
                }

                oos.writeObject(response);
                oos.flush();

                // close処理
                if(isValid){
                    ois.close();
                    oos.close();
                }
            }
            // socketの終了。
            oos.close();
            ois.close();
            socket.close();
            server.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}