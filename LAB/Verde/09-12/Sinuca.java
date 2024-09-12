import java.util.Scanner;

/**
 * Sinuca
 */

public class Sinuca {

    public static String verificarBola(int[] array){

        int n = array.length;
        String resultado = "";
        boolean acabou = false;

        while(!acabou){

            for(int i = 0;i < n - 1;i++){

                if(array[i] == array[i + 1]){
                    array[i] = 1;
                }else{
                    array[i] = -1;
                }

            }

            n--;

            if(n == 1){
                acabou = true;
            }

        }

        if(array[0] == 1){
            resultado = "preta";
        }else if(array[0] == -1){
            resultado = "branca";
        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] array = new int[n];

        for(int i = 0;i < n;i++){

            array[i] = scan.nextInt();

        }

        String resultado = verificarBola(array);

        System.out.println(resultado);

        scan.close();

    }
    
}