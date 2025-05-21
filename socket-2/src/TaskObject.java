import java.io.Serializable;

public class TaskObject implements Serializable, ITask{
    int num;
    boolean isCalculated;
    boolean[] primeMap;

    public TaskObject() {
        num = 0;
        isCalculated = false;
    }

    @Override
    public void setExecNumber(int x) {
        num = x;
    }

    @Override
    public void exec() {
        System.out.println("Calculating...");
        // エラストテネスのふるい
        boolean[] isPrime = new boolean[num+1];
        for (int i=0; i <= num; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;

        for(int i = 2; i <= num; i++) {
            // System.out.println(i);
            if(!isPrime[i]){
                // System.out.println("Already calculated");
                continue;
            }
            
            for(int j = i * 2; j <= num; j += i) {
                // System.out.println("Setting " + j + " to false");
                isPrime[j] = false;
            }
        }
        isCalculated = true;
        primeMap = isPrime;
        System.out.println("Calculation finished");
    }   

    @Override
    public int getResult() {
        if(!isCalculated) {
            return -1;
        }

        // for(boolean e: primeMap) {
        //     if(e) {
        //         System.out.println("Prime number found");
        //     }else {
        //         System.out.println("Not a prime number");
        //     }
        // }

        int i = num;
        while(!primeMap[i] && i > 0) {
            i--;
        }
        return i;
    }
    public static void main(String[] args) {
        TaskObject task = new TaskObject();
        task.setExecNumber(500000);
        task.exec();
        System.out.println("Next prime number after " + task.num + " is: " + task.getResult());
    }
}

