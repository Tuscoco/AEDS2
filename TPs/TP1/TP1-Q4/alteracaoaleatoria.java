import java.util.*;

/**
 * alteracaoaleatoria
 */

public class alteracaoaleatoria {

    public static String substituir(String str,char c,char s){

        /*
         * Esse método compara cada caractere da string com o caractere na variavel c, que foi gerado randomicamente;
         * Se a comparação der verdadeiro, o caractere irá ser substituido pelo caractere na variavel s, que foi gerado randomicamente;
         * Se a comparação der falso, o caractere será mantido e vai ser adicionado na variavel resultado;
         */

        String resultado = new String();
        
        for(int i = 0;i < str.length();i++){

            if(str.charAt(i) == c){

                resultado += s;

            }else{

                resultado += str.charAt(i);

            }

        }

        return resultado;

    }

    public static boolean fim(String str){
        
        /*
         * Esse método basicamente verifica se a String enviada contem a palavra "FIM";
         * Caso verdadeiro, o metodo retorna true;
         */

        boolean resultado = false;

        if(str.charAt(0) == 'F' && str.charAt(1) == 'I' && str.charAt(2) == 'M'){

            resultado = true;

        }

        return resultado;

    }
    
    public static void main(String[] args) {
        
        Random gerador = new Random(); 
        gerador.setSeed(4);

        Scanner scan = new Scanner(System.in);

        String str = "";
        String strResultante = str;

        do{

            str = scan.nextLine();

            if(!fim(str)){

                char caractere = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
                char caractereSubstituto = (char)('a' + (Math.abs(gerador.nextInt()) % 26));

                strResultante = substituir(str, caractere, caractereSubstituto);

                System.out.println(strResultante);

            }

        }while(!fim(str));

        scan.close();

    }
    
}