public class threads3{
    public static void main(String[] args) {
        int a = 5;
        int b = 100;
        int meio = a + (b-a) /2;
    
        Thread t1 = new Thread(new Primos(a, meio));
        Thread t2 = new Thread(new Primos(meio +1, b));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    public static boolean ehPrimo(int n){
        if (n <=1){
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    static class Primos implements Runnable {
        private int start;
        private int end;

        public Primos (int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public void run(){
            for (int i = start; i <= end; i++ ){
                if (ehPrimo(i)){
                    System.out.println(i);
                }
            }
        }
    }
}
