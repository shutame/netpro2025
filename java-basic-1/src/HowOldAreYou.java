// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

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

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			// BufferedReader というのは、データ読み込みのクラス(型)
			// クラスの変数を作るには、new を使う。

			// readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
			//  Java では、 try{ XXXXXXXX }  catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
		try {
			System.out.println("何歳ですか?");
			String line = reader.readLine();
			int age = Integer.parseInt(line);
            if(age < 0 || age > 120) {
                System.out.println("年齢は0以上120以下で入力してください。");
                return;
            }
			System.out.println("あなたは" + age + "歳ですね。");
			System.out.println("あなたは10年後、" + (age + 10) + "歳ですね。");

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
		catch(IOException e) {
			System.out.println(e);
		}


	}
}

//  課題    キーボードから数字を打ち込む
//  その結果、 あなたは、???歳ですね、と画面に表示させる。
//  その後、あなたは10年後、????歳ですね、と画面に表示させる。
