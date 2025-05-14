package ex3;
import java.util.Scanner;

public class XmasTree {
    int leavesOfBottom;
    int widthOfStem;
    int heightOfStem;
    char flake;

    public XmasTree(int lob, int wos, int hos, char flake) {
        this.leavesOfBottom = lob;
        this.widthOfStem = wos;
        this.heightOfStem = hos;
        this.flake = flake;
    }

    public void draw(){
        int height = leavesOfBottom + heightOfStem;
        int width = leavesOfBottom;

        for(int i=0; i < height; i++){
            for(int j=0; j < width; j++){
                if(i < leavesOfBottom){
                    if (j >= width/2 - i && j <= width/2 + i){
                        System.out.print("*");
                    }else if (i == j){
                        System.out.print(flake);
                    }else {
                        System.out.print(" ");
                    }
                }else{
                    // System.out.println(width/2 - widthOfStem/2);
                    if(j > width/2 - widthOfStem/2 && j < width/2 + widthOfStem/2)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
    }
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("(葉,幅,高さ,雪)");

        String line = scanner.nextLine();
        String[] parts = line.split(",");
        int lob = Integer.parseInt(parts[0]);
        int wos = Integer.parseInt(parts[1]);
        int hos = Integer.parseInt(parts[2]);
        char flake = parts[3].charAt(0);

        XmasTree tree = new XmasTree(lob, wos, hos, flake);
        tree.draw();
    }
}
