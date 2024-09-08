import java.util.Scanner;

/**
 * Main
 */

public class Main {

    public static void swap(int[] array,int menor,int i){
        int tmp = array[i];
        array[i] = array[menor];
        array[menor] = tmp;
    }
    
    public static void ordenar(int[] array){

        for(int i = 0;i < (array.length - 1);i++){

            int menor = i;

            for(int j = (i + 1);j < array.length;j++){

                if(array[menor] > array[j]){

                    menor = j;

                }

            }

            swap(array, menor, i);

        }

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int[] array = new int[3];
        int[] arrayA = new int[3];

        for(int i = 0;i < 3;i++){

            array[i] = scan.nextInt();

            arrayA[i] = array[i];

        }

        ordenar(array);

        for(int x : array){

            System.out.println(x);

        }

        System.out.println();

        for(int x : arrayA){

            System.out.println(x);

        }

        scan.close();

    }
    
}