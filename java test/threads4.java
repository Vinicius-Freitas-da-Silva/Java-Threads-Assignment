import java.util.ArrayList;

public class threads4{
    public static void main(String[] args) {
        int a = 3;
        int b = 1000;
        int intervalo = 50;

        ArrayList<Thread> threads = new ArrayList<>();
    
        for (int i = a; i <= b; i += intervalo){
            int fim = Math.min(i+intervalo -1, b);
            Thread thread = new Thread(new Primos(i, fim));
            threads.add(thread);
            thread.start();
        }

        for (Thread t: threads){
            try {
                t.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
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
