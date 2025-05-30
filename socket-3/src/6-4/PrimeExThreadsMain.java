import java.util.ArrayList;

public class PrimeExThreadsMain extends Thread{
    int start;
    int end;

    public PrimeExThreadsMain(int start, int end) {
        this.start = start;
        this.end = end;
    }

    boolean isPrime(int num){
        for(int i=2; i < Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public void run() {
        System.out.println("[Start]" + start + "-" + end);

        var prime = new ArrayList<Integer>();
        for(int num = start; num < end; num++){
            if(isPrime(num)){
                prime.add(num);
            }
        }

        var sb = new StringBuilder();
        sb.append("[Prime]" + start + "-" + end + ": ");
        sb.append(prime.toString());
        System.out.println(sb.toString());
    }

    public static void main(String[] args){
        var threads = new ArrayList<PrimeExThreadsMain>();
        for(int i=1; i<=9; i++){
            threads.add(new PrimeExThreadsMain(100*i, 100*(i+1) -1));
        }

        for(PrimeExThreadsMain th : threads){
            th.start();
        }
    }

}
