import java.util.*;

/**
 * Main
 */

public class Main {

    public static int[] maiorEmenor(int[] array){

        int[] resultado = new int[2];

        resultado[0] = array[0];
        resultado[1] = array[0];

        for(int i = 1;i < array.length;i++){

            if(resultado[0] < array[i]){
                resultado[0] = array[i];
            }else if(resultado[1] > array[i]){
                resultado[1] = array[i];
            }
            
        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int[] array = {0,1,2,3,4,5,6,7,8,9,10};

        int[] resultado = maiorEmenor(array);


        System.out.println("Maior: " + resultado[0]);
        System.out.println("Menor: " + resultado[1]);

        scan.close();
        
    }
    
}