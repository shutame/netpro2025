package ex2;
import java.util.Random;

public class TheBoilingEarthEraC {
    private static enum 年度 {
        y2016(0),
        y2017(1),
        y2018(2),
        y2019(3),
        y2020(4),
        y2021(5),
        y2022(6),
        y2023(7),
        y2024(8),
        y2025(9);

        private final int index;
        年度(int index) {
            this.index = index;
        }
        public int getYear() {
            return 2016+index;
        }
        public double getAveTemp(){
            return 29.0 + index * 0.3;
        }

    }
    public static void main(String[] args) {
        double[][] temperatures = new double[10][31];
            double aveTemp = 年度.values()[9].getAveTemp();
            // System.out.println("平均気温: " + aveTemp + "℃");
            StringBuffer hotStr = new StringBuffer();

            Random rand = new Random();
            for(int i = 0; i < 10; i++){
                Boolean prevIsHotDay = false;
                for(int j = 0; j < 31; j++){
                    double delta = rand.nextInt(11) - 5 + rand.nextDouble(); 
                    temperatures[i][j] = Math.floor((aveTemp + delta) * 10) / 10;
                    System.out.println((2016+i) + "年7月" + (j+1) + "日: " + temperatures[9][j] + "℃");

                    if(temperatures[i][j] >= 30.0){
                        if(prevIsHotDay){
                            String str = (2016+i) + "年" + "7月" + j + "日: " + temperatures[i][j-1] + "℃ と " +
                                (2016+i) + "年" + "7月" + (j+1) + "日: " + temperatures[i][j] + "℃" + "\n";
                            hotStr.append(str);
                        }
                        prevIsHotDay = true;
                    }else{
                        prevIsHotDay = false;
                    }
                }
            }
        System.out.println("猛暑日連続ペア");
        System.out.println(hotStr.toString());

    }
}

