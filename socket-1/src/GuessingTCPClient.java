import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class GuessingTCPClient {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("127.0.0.1", port);
            System.out.println("接続されました");

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            System.out.println("数当てゲーム！！！");
            int i = 0;
            boolean isFaild = true;
            while (isFaild){
                System.out.println("何番かな？(0-10の整数を入力)");
                String content = scanner.next();

                Payload payload = new Payload();
                String message = String.format("%d", i);
                payload.setMessage(message);
                payload.setContent(content);

                oos.writeObject(payload);
                oos.flush();

                Payload responce = (Payload) ois.readObject();

                String replayContent = responce.getContent();
                System.out.println(replayContent);

                if (responce.getMessage().equals("success")){
                    isFaild = false;
                }
                i++;
            }
            oos.close();
            ois.close();
            scanner.close();
            socket.close();

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
