import java.util.Arrays;

public class PrimeCheck {
    static final int N = 100000; 
    public static void main(String[] args){
        //エラストテネスの篩
        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i < N; i++){
            if(!isPrime[i]) continue; // iが素数でない場合はスキップ

            for(int j = i * 2; j < N; j += i){
                isPrime[j] = false; // iの倍数を除外
            }
        }
    }
}
