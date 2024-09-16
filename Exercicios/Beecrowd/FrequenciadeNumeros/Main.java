import java.util.*;

/**
 * Main
 */

public class Main {

    public static void sort(int[] array){

        for(int i = 1;i < array.length - 1;i++){

            int tmp = array[i];
            int j = i - 1;

            while((j >= 0) && (array[j] > tmp)){
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = tmp;

        }

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] array = new int[n];

        for(int i = 0;i < n;i++){

            array[i] = scan.nextInt();

        }

        sort(array);

        

        scan.close();

    }
    
}