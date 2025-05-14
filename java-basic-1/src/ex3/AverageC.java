package ex3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class AverageC {
	private static final int n = 100;
	public static void main(String[] args){
		// データの生成
		ArrayList<Subject> scores = new ArrayList<Subject>();
		Random rand = new Random();
		for(int i=0; i < n; i++){
			scores.add(new Subject(rand.nextInt(101)));
			// System.out.println(scores.get(i).getScore());
		}

		// 合格者判定
		ArrayList<Subject> passed = new ArrayList<Subject>();
		for(int i=0; i < n; i++){
			if(scores.get(i).getScore() >= 80){
				Subject s = new Subject(scores.get(i).getScore());
				s.setId(i+100);
				passed.add(s);
			}
		}
		passed.sort(Comparator.comparing(Subject::getScore));

		// 平均点
		double ave = 0;
		for(Subject s : scores){
			ave += s.getScore();
		}
		ave /= (double)n;

		// 出力
		System.out.println("受験者全体での平均点は" + ave + "点です。");		
		System.out.println("合格者は以下の通りです。");
		System.out.println("受験番号,点数");
		for(Subject s : passed){
			System.out.println(s.getId() + "," + s.getScore());
		}

	}
}
