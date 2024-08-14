/**
 * palindromo
 */

public class palindromo {

    public static boolean fim(String str){

        boolean resultado = false;

        if(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){

            resultado = true;

        }

        return resultado;

    }
    
    public static boolean ehPalindromo(String str){

        boolean resultado = true;
        int length = str.length();
        int i = 0;
        int j = 0;

        for(i = 0,j = length - 1; i < length/2; i++,j--){

            if(str.charAt(i) != str.charAt(j)){
                resultado = false;
                i = length;
            }

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        String str;

        do{

            str = MyIO.readString();

            if(!fim(str)){

                if(ehPalindromo(str)){
                    System.out.println("SIM");
                }else{
                    System.out.println("NAO");
                }

            }

        }while(!fim(str));
        
    }

}