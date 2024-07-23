import java.util.*;


public class palindromorecursivo {

    public static boolean fim(String str){

        boolean fim = false;

        if(str.equals("FIM"))
        {
            fim = true;
        }

        return fim;

    }

    static int n = 0;

    public static boolean ehPalindromo(String str, int length, int i){

        boolean resultado = true;

        if(str.charAt(n) != str.charAt(length)){
            resultado = false;
            return resultado;
        }

        if(n == str.length()/2){
            return resultado;
        }

        return ehPalindromo(str, length - 1, n + 1);

    }
    
    public static void main(String[] args) {
        
        String str;
        Scanner scan = new Scanner(System.in);

        do{

            str = scan.nextLine();

            if(!fim(str)){

                if(ehPalindromo(str,str.length(),n)){
                    System.out.println("SIM");
                }else{
                    System.out.println("NAO");
                }

            }

        }while(!fim(str));

        scan.close();
        
    }

}

////////////ERRADO