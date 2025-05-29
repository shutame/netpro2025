// Runnable インターフェースを実装することで、このクラスのインスタンスはスレッドとして実行可能になります。

import java.util.ArrayList;

public class CountAZTenRunnable implements Runnable {
    // main メソッドはプログラムのエントリーポイントです。
    public static void main(String[] args){
        // 2つの文字を初期化します。
        // char c1 = 97; // ASCII値 97 は 'a' です
        // char c2 = (char)(c1 + 1); // c1 に 1 を足すと ASCII値 98 になり、'b' になります

        // 初期化した文字をコンソールに出力します。
        // System.out.println(c1); // 出力: a
        // System.out.println(c2); // 出力: b

        // CountTenRunnable クラスのインスタンスを作成します。

        //実行すスレッドのリストを作成
        ArrayList<Thread> threads = new ArrayList<Thread>();
        for(int i = 0; i < 26; i++) {
            char c = (char)(97 + i); // ASCII値 97 は 'A' です
            // System.out.println(c); // 出力: a, b, c, ..., z
            threads.add(new Thread(new CountAZTenRunnable(c)));
        }

        // スレッドを実行
        for(Thread th : threads) {
            th.start();
        }
        // ct を実行する新しいスレッドを作成します。
        // Thread th = new Thread(ct);

        // スレッドを開始します。これにより、CountTenRunnable の run メソッドが呼び出されます。
        // th.start();

        // この try-catch ブロックは、0 から 9 までの値を 500 ミリ秒間隔で出力するループを実行します。
        // try {
        //     for(int i = 0; i < 27; i++) {

        //         // メインスレッドを 500 ミリ秒間一時停止します。
        //         Thread.sleep(500);  // ミリ秒単位のスリープ時間
        //     }
        // }
        // catch(InterruptedException e) {
        //     // スレッドが中断された場合は、例外を出力します。
        //     System.err.println(e);
        // }
    }

    char c;
    public CountAZTenRunnable(char c) {
        this.c = c;
    }
    // run メソッドは、新しいスレッドが実行するコードを含みます。
    public void run() {
        // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
        try {
            for(int i = 0; i <= 10; i++) {
                String str = String.valueOf(c) + i;
                System.out.println(str);

                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(1000);  // ミリ秒単位のスリープ時間
            }
        }
        catch(InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
}