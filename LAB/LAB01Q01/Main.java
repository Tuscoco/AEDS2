import java.util.Scanner;

/**
 * Main
 */

public class Main {

    public static int maiusculos(String str){

        int resultado = 0;
        int length = str.length();

        for(int i = 0;i < length;i++){

            if(Character.isUpperCase(str.charAt(i))){
                resultado++;
            }

        }

        return resultado;
    }

    public static boolean fim(String str){

        boolean resultado = false;

        if(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){

            resultado = true;

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        String str = "START";

        do{

            str = scan.nextLine();

            if(!fim(str)){

                int m = maiusculos(str);

                System.out.println(m);

            }

        }while(!fim(str));

        scan.close();

    }
    
}