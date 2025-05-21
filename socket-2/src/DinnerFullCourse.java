import java.io.BufferedWriter;
import java.io.FileWriter;

public class DinnerFullCourse {
    private Dish[] list = new Dish[5];// [0]-[4]の計5個

    public DinnerFullCourse() {
        list[0] = new Dish();
        list[0].setName("ポテトサラダ");
        list[0].setValune(300);

        list[1] = new Dish();
        list[1].setName("コーンポタージュ");
        list[1].setValune(350);

        list[2] = new Dish();
        list[2].setName("ジェラート");
        list[2].setValune(200);

        list[3] = new Dish();
        list[3].setName("ステーキ");
        list[3].setValune(1500);

        list[4] = new Dish();
        list[4].setName("プリン");
        list[4].setValune(400);

    }

    void eatAll(){
        StringBuffer sb = new StringBuffer();
        for(Dish e : list){
            sb.append(e.getName() + "=" + e.getValune());
            if(e != list[list.length - 1]){
                sb.append(",");
            }
        }
        sb.append("を食べました。");
        System.out.println(sb.toString());

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("DinnerFullCourse_Results.txt"));
            bw.write(sb.toString());
            bw.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }


	public static void main(String[] args) {

		DinnerFullCourse fullcourse = new DinnerFullCourse();
		fullcourse.eatAll();
	}
    
}
