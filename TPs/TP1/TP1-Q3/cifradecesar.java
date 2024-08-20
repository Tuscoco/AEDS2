import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.*;

/**
 * cifradecesar
 */

public class cifradecesar {
    
    public static String criptografar(String str, int chave){

        int i = 0;
        char[] resultadochar = str.toCharArray();

        for(i = 0;i < str.length();i++){

            int letra = str.charAt(i);

            if(letra + chave > 126){

                if(letra >= 32 && letra <= 126){

                    int temp = letra + chave;

                    temp -= 94;
        
                    resultadochar[i] = (char) temp;

                }else{

                    resultadochar[i] = str.charAt(i);

                }

            }else if(letra >= 32 && letra <= 126){

                resultadochar[i] = (char) (letra + chave);

            }else{

                resultadochar[i] = str.charAt(i);

            }

        }

        String result = new String(resultadochar);

        String resultado = result.replace("ï¿½","�");

        return resultado;

    }

    public static String criptografar(String str){
        return criptografar(str, 3);
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
        String texto;

        do{

            texto = scan.nextLine();

            if(!fim(texto)){

                String temp = criptografar(texto);

                System.out.println(temp);

            }

        }while(!fim(texto));

        scan.close();

    }

}