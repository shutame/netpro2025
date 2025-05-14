package ex3;
public class MyExceptionHoliday {
    public static void main(String[] args) {
        System.out.println("5月の何日ですか?(\"exit\"を入力すると終了します.)");
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String input = scanner.nextLine();

        
        while (!input.equals("exit")) {
            try {
                int day = Integer.parseInt(input);
                if(day < 1 || day > 31) {
                    throw new IllegalArgumentException("1から31の間で入力してください。");
                }

                boolean isHoliday = 
                        day == 3 || day == 4 || day == 10 ||
                        day == 11 || day == 17 || day == 18 || day == 24 ||
                        day == 25 || day == 31 || day == 5 || day == 6;

                if(!isHoliday){
                    throw new NoHolidayException("平日だhttps://soude.su \n" +"https://iyado.su");
                }

                System.out.println(day + "日はお休みです。");
                System.out.println("https://ofuton.in");
            }catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }catch (NoHolidayException e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
            System.out.println("5月の何日ですか?(\"exit\"を入力すると終了します.)");
            input = scanner.nextLine();
        } 
    }
}
