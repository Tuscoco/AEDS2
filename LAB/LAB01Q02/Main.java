import java.util.Scanner;

/**
 * Main
 */

public class Main {

    public static int maiusculos(String str,int c,int n){

        if(c == str.length()){

            return n;

        }else if(Character.isUpperCase(str.charAt(c))){

            n++;

        }

        return maiusculos(str, c + 1, n);

    }

    public static int maiusculos(String str){
        return maiusculos(str, 0, 0);
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