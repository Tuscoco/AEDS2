import java.util.*;

/**
 * main
 */
public class Main {

    public static boolean verificarArray(int[] array, int n){

        boolean resultado = false;
        
        for(int i = 0;i < array.length;i++){

            if(array[i] == n){
                resultado = true;
            }

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int[] array = {0,1,2,3,4,5,6,7,8,9};

        int n = scan.nextInt();

        if(verificarArray(array, n)){
            System.out.println("SIM");
        }else{
            System.out.println("NAO");
        }

        scan.close();

    }

}