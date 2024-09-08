import java.text.DecimalFormat;
import java.util.*;

/**
 * Main
 */

public class Main {

    public static void swap(int[] array,int maior,int menor){
        int tmp = array[maior];
        array[maior] = array[menor];
        array[menor] = tmp;
    }
    
    public static void ordenar(int[] array){

        for(int i = (array.length - 1);i > 0;i--){

            for(int j = 0;j < i;j++){

                if(array[j] > array[j + 1]){

                    swap(array, j, j + 1);

                }

            }

        }

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        do{

            int n = scan.nextInt();

            int[] array = new int[n];

            for(int i = 0;i < n;i++){

                array[i] = scan.nextInt();

            }

            ordenar(array);

            for(int x : array){

                String resultado = String.format("%04d", x);
                System.out.println(resultado);

            }

        }while(scan.hasNextInt());

        scan.close();

    }
    
}