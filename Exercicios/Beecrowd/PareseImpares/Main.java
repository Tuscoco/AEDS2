import java.util.*;

/**
 * Main
 */

public class Main {

    public static void ordenar(int[] array){

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] array = new int[n];

        for(int i = 0;i < n;i++){

            array[i] = scan.nextInt();

        }

        ordenar(array);

        for(int x : array){

            System.out.println(x);

        }

        scan.close();

    }
    
}