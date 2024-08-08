import java.util.*;

/**
 * Main
 */

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int op = scan.nextInt();

        long[] fib = fibonacci();

        for(int i = 0;i < op;i++){

            int num = scan.nextInt();

            verificar(num,fib);

        }

        scan.close();

    }
    
    public static long[] fibonacci(){

        long[] fib = new long[61];

        long n1 = 0;
        long n2 = 1;

        fib[0] = n1;
        fib[1] = n2;

        for(int i = 2;i < 61;i++){

            long soma = n1 + n2;

            fib[i] = soma;

            n1 = n2;
            n2 = soma;

        }

        return fib;

    }
    
    public static void verificar(int n,long[] fib){
 
        System.out.println("Fib(" + n + ") = " + fib[n]);

    }

}