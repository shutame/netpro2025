//ユーザの現在の年齢を入力し、10年後の年齢を表示するプログラム
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrintYourAge {
    private static enum 元号 {
        明治(1868),
        大正(1912),
        昭和(1926),
        平成(1989),
        令和(2019);

        private final int startYear;
        private 元号(int startYear) {
            this.startYear = startYear;
        }
        public int getStartYear() {
            return startYear;
        }
    }
	public static void main(String[] args) {
		// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader というのは、データ読み込みのクラス(型)
			// クラスの変数を作るには、new を使う。

			// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
			//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX } と書く
        Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("何歳ですか?");
			// String line = reader.readLine();
			// int age = Integer.parseInt(line);
            int age = scanner.nextInt();
            scanner.close();
            if(age < 0 || age > 120) {
                throw new InputMismatchException();
            }
			System.out.println("あなたは" + age + "歳ですね。");
			System.out.println("あなたは10年後に、" + (age + 10) + "歳ですね。");

            // 2030年時点の年齢
            int year = java.time.Year.now().getValue();
            System.out.println("あなたは2030年では" + (age + (2030 - year)) + "歳ですね。");

            //誕生日の元号
            // Rustの範囲マッチをJavaで使いたい
            int birthYear = year - age;
            String strBirthEra;
            if(birthYear >= 元号.令和.getStartYear()) {
                strBirthEra = "令和" + (birthYear - 元号.令和.getStartYear() + 1) + "年";
            } else if(birthYear >= 元号.平成.getStartYear()) {
                strBirthEra = "平成" + (birthYear - 元号.平成.getStartYear() + 1) + "年";
            } else if(birthYear >= 元号.昭和.getStartYear()) {
                strBirthEra = "昭和" + (birthYear - 元号.昭和.getStartYear() + 1) + "年";
            } else if(birthYear >= 元号.大正.getStartYear()) {
                strBirthEra = "大正" + (birthYear - 元号.大正.getStartYear() + 1) + "年";
            } else {
                strBirthEra = "明治" + (birthYear - 元号.明治.getStartYear() + 1) + "年";
            }
            System.out.println("あなたは" + strBirthEra + "生まれですね。");
		}
		catch(InputMismatchException e) {
            System.out.println("有効な数値(0..120)を入力してください。");
        }
	}
}
