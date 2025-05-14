class Renshu {
    // xを2倍にして返す関数
    public int doubleValue(int x) {
        return x * 2;
    }

    //ここに続きを実装していく。
    int sumUpToN(int n){
        return n * (n + 1) / 2;
    }

    int sumFromPtoQ(int p, int q){
        if(p > q){
            return -1; 
        }

        return (q-p+1) * (p+q) / 2;
    }

    int sumFromArrayIndex(int[] a, int index){
        if (index < 0 || index >= a.length) {
            return -1;
        }

        int sum = 0;
        for (int i = index; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }

    int selectMaxValue(int[] a){
        int max = a[0];
        for (int e: a){
            if (e > max){
                max = e;
            }
        }
        return max;
    }

    int selectMaxIndex(int[] a){
        int max = a[0];
        int index = 0;
        
        for (int i = 0; i < a.length; i++){
            if(a[i] > max){
                max = a[i];
                index = i;
            }
        }
        return index;
    }

    int selectMinValue(int[] a){
        int min = a[0];
        for (int e: a){
            if (e < min){
                min = e;
            }
        }
        return min;
    }

    int selectMinIndex(int[] a){
        int min = a[0];
        int index = 0;
        
        for (int i = 0; i < a.length; i++){
            if(a[i] < min){
                min = a[i];
                index = i;
            }
        }
        return index;
    }

    void swapArrayElements(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    boolean swapTwoArrays(int[] a, int[] b){
        if(a.length != b.length){
            return false;
        }

        for (int i = 0; i < a.length; i++){
            int tmp = a[i];
            a[i] = b[i];
            b[i] = tmp;
        }

        return true;
    }

}