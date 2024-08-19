import java.util.*;

/**
 * Main
 */

public class Main {

    public static int menor(int[] array,int valor){

        int valorConta = valor;
        int menor = valor;

        for(int i = 0;i < array.length;i++){
            
            valorConta += array[i];

            if(valorConta < menor){

                menor = valorConta;

            }

        }

        return menor;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(),valorI = scan.nextInt();

        int[] array = new int[n];
        
        for(int i = 0;i < n;i++){

            array[i] = scan.nextInt();

        }

        int m = menor(array, valorI);

        System.out.println(m);

        scan.close();

    }
    
}