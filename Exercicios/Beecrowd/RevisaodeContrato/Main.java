import java.util.*;

/**
 * Main
 */

public class Main {

    public static String verificar(String[] array){

        array[1] = array[1].replace(array[0], "");

        String resultado = array[1];

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String[] array;
        
        do{

            String num = scan.nextLine();

            array = num.split(" ");

            if(array[0] != "0" && array[1] != "0"){

                System.out.println(verificar(array));

            }

        }while(array[0] != "0" && array[1] != "0");

        scan.close();

    }
    
}