import java.util.*;

/**
 * cifradecesar
 */

 public class cfrecursivo {
    
    public static String criptografar(String str, int chave,int c){

        if(c == str.length()){

            str = str.replace("ï¿½","�");
            String resultado = str;

            return resultado;

        }
        
        char[] resultadochar = str.toCharArray();

        int letra = str.charAt(c);

        if(letra + chave > 126){

            if(letra >= 32 && letra <= 126){

                int temp = letra + chave;

                temp -= 94;
    
                resultadochar[c] = (char) temp;

            }else{

                resultadochar[c] = str.charAt(c);

            }

        }else if(letra >= 32 && letra <= 126){

            resultadochar[c] = (char) (letra + chave);

        }else{

            resultadochar[c] = str.charAt(c);

        }

        return criptografar(new String(resultadochar), chave, c + 1);

    }

    public static String criptografar(String str){
        return criptografar(str, 3,0);
    }

    public static boolean fim(String str){

        boolean resultado = false;

        if(str.equals("FIM")){

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

                String temp = criptografar(str);

                System.out.println(temp);

            }

        }while(!fim(str));

        scan.close();

    }

}