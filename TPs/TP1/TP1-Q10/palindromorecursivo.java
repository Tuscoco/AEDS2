import java.util.*;

public class palindromorecursivo {

    public static boolean fim(String str){

        boolean resultado = false;

        if(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){

            resultado = true;

        }

        return resultado;

    }

    public static boolean ehPalindromo(String str){
        return ehPalindromo(str, 0);
    }

    public static boolean ehPalindromo(String str,int c){

        boolean resultado;

        if(c == str.length()/2){

            resultado = true;

        }else if(str.charAt(c) != str.charAt(str.length() - c - 1)){

            resultado = false;

        }else{

            return ehPalindromo(str, c + 1);

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String str = "SLA";

        do{

            str = scan.nextLine();
            //str = MyIO.readString();

            if(!fim(str)){

                if(ehPalindromo(str)){
                    System.out.println("SIM");
                }else{
                    System.out.println("NAO");
                }

            }

        }while(!fim(str));

        scan.close();
        
    }

}