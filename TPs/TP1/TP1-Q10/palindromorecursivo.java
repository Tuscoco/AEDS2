
public class palindromorecursivo {

    public static boolean fim(String str){

        boolean fim = false;

        if(str.equals("FIM"))
        {
            fim = true;
        }

        return fim;

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