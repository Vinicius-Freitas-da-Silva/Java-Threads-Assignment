public class threads {
    public static void main(String[] args) {
        Primos(5 ,17);
    }
    public static void Primos (int a, int b){
        for (int i = a; i<=b; i++){
            int divs = 0;
            for (int j = 2; j <= i; j++){
                if ((i%j) == 0){
                    divs++;
                }
            }
            if (divs <= 1){
                System.err.println(i);
            }
        }
    }

}
