import java.util.*;

/**
 * Main
 */

public class Main {

    public static void swap(int[] array, int menor, int j){
        int tmp = array[menor];
        array[menor] = array[j];
        array[j] = tmp;
    }
    
    public static void ordenar(int[] array){

        int n = array.length - 1;
        
        for(int i = 0;i < array.length - 1;i++){

            int menor = i;

            for(int j = i + 1;j < array.length;j++){

                if(array[menor] > array[j]){

                    menor = j;

                }

            }

            if(menor % 2 == 0){

                swap(array, menor, i);

            }else{

                swap(array, menor, n);
                n--;

            }

        }

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