public class threads2{
    public static void main(String[] args) {
        int a = 5;
        int b = 17;
    
        Thread ehPrimo = new Thread(() ->{
            for (int i = a; i<=b; i++){
                int divs = 0;
                for (int j = 2; j <= i; j++){
                    if ((i%j) == 0){
                        divs++;
                    }
                }
                if (divs <= 1){
                    System.out.println(i);
                }
            }
        });

        ehPrimo.start();

        try {
            ehPrimo.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
